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
			.antMatchers(HttpMethod.DELETE, "/auth/requests/{id}").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/auth/requests").authenticated()
			.antMatchers(HttpMethod.POST, "/auth/requests/patrons/{pid}").hasRole("PATRON")
			.antMatchers("/auth/products/category/{cid}").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.POST, "/auth/patrons").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/auth/patrons").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/auth/patrons/{cid}").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.GET, "/auth/users").hasRole("LIBRARIAN")
			.antMatchers(HttpMethod.PUT, "/auth/patrons/{cid}").hasRole("LIBRARIAN")
			.anyRequest().permitAll()
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
