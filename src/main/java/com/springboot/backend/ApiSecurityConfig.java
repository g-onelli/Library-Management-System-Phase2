package com.springboot.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.backend.service.MyUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//configure our apis as per roles
		http.authorizeRequests()
			.antMatchers(HttpMethod.DELETE, "/requests/{id}").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/requests").hasAnyAuthority("PATRON,LIBRARIAN")
			.antMatchers(HttpMethod.POST, "/requests/patrons/{pid}").hasAuthority("PATRON")
			.antMatchers("/auth/products/category/{cid}").hasAuthority("LIBRARIAN")
			.antMatchers("users").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.POST, "/patrons").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/patrons").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/patrons/{cid}").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/users").hasAuthority("LIBRARIAN")
			.antMatchers(HttpMethod.PUT, "/patrons/{cid}").hasAuthority("LIBRARIAN")
			//.anyRequest().permitAll()
			.and().httpBasic()
			.and().csrf().disable();
}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	//build our custom authManager
		auth.authenticationProvider(getCustomProvider());
		
}			


	@Bean
	public PasswordEncoder getPasswordEncoder(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	private DaoAuthenticationProvider getCustomProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailsService);
		return dao;
	}
	
}
