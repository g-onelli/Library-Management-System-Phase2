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
			.antMatchers(HttpMethod.POST, "/signup").permitAll()
			.antMatchers(HttpMethod.GET, "/login").authenticated()
			.antMatchers(HttpMethod.GET, "/role").authenticated()
			.antMatchers(HttpMethod.GET, "/requests").authenticated() //View book requests (GET)
			.antMatchers(HttpMethod.POST, "/requests/{id}/{gen}/{pub}").authenticated() //Complete book requests (POST and DELETE)
			.antMatchers(HttpMethod.POST, "/requests/patrons/**").authenticated()//Submit book requests (POST)
			.antMatchers(HttpMethod.POST, "/patrons").authenticated() //Register patrons (POST)
			.antMatchers(HttpMethod.GET, "/patrons/").authenticated() //View patrons (GET)
			.antMatchers(HttpMethod.DELETE, "/patrons/{id}/").authenticated() //Remove patrons(DELETE)
			.antMatchers(HttpMethod.PUT, "/patrons/").authenticated()
			.antMatchers(HttpMethod.PUT, "/patrons/card/{id}").authenticated() //Renew library card (PUT)
			.antMatchers(HttpMethod.PUT, "/patrons/balance/{id}").authenticated()//Update patron balance (PUT)
			.antMatchers(HttpMethod.POST, "/event/{lid}").authenticated()
			.antMatchers(HttpMethod.GET, "/event").authenticated()
			.antMatchers(HttpMethod.GET, "/event/{id}").authenticated()
			.antMatchers(HttpMethod.DELETE, "/event/{id}").authenticated()
			.antMatchers(HttpMethod.PUT, "/event/{id}").authenticated()
			.antMatchers(HttpMethod.POST, "/fee/{pid}").authenticated()
			.antMatchers(HttpMethod.GET, "/fee").authenticated()
			.antMatchers(HttpMethod.GET, "/fee/{id}").authenticated()
			.antMatchers(HttpMethod.PUT, "/fee/{id}").authenticated()		
			//.anyRequest().denyAll() //Anything not declared will be denied
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
