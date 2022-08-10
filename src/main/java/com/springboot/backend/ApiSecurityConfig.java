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
			.antMatchers(HttpMethod.GET, "/requests").hasAnyAuthority("LIBRARIAN") //View book requests (GET)
			.antMatchers(HttpMethod.POST, "/requests/{id}/{gen}/{pub}").hasAuthority("LIBRARIAN") //Complete book requests (POST and DELETE)
			.antMatchers(HttpMethod.POST, "/requests/patrons/{pid}").hasAuthority("PATRON") //Submit book requests (POST)
			.antMatchers(HttpMethod.POST, "/patrons").hasAuthority("LIBRARIAN") //Register patrons (POST)
			.antMatchers(HttpMethod.GET, "/patrons").hasAuthority("LIBRARIAN") //View patrons (GET)
			.antMatchers(HttpMethod.DELETE, "/patrons/{id}").hasAuthority("LIBRARIAN") //Remove patrons(DELETE)
			.antMatchers(HttpMethod.PUT, "/patron/card/{id}").hasAuthority("LIBRARIAN") //Renew library card (PUT)
			.antMatchers(HttpMethod.PUT, "/patrons/balance/{id}").hasAuthority("LIBRARIAN") //Update patron balance (PUT)
			.antMatchers(HttpMethod.GET, "/users").hasAuthority("LIBRARIAN") //FOR TESTING: shows user info
			.antMatchers(HttpMethod.GET, "/book").hasAnyAuthority("PATRON") //View books (GET)
			.antMatchers(HttpMethod.GET, "/video").hasAnyAuthority("PATRON") //View videos  (GET)
			.antMatchers(HttpMethod.GET, "/checkedoutbook").hasAnyAuthority("PATRON") //View checked out books (GET)
			.antMatchers(HttpMethod.POST, "/checkedoutbook/{pid}/{bid}").hasAnyAuthority("PATRON") //Check out a book (POST)
			.antMatchers(HttpMethod.DELETE, "/checkedoutbook/{bid}").hasAnyAuthority("PATRON") //Check in a book (DELETE)
			.antMatchers(HttpMethod.GET, "/checkedoutvideo").hasAnyAuthority("PATRON") //View checked out videos (GET)
			.antMatchers(HttpMethod.POST, "/checkedoutvideo/{pid}/{vid}").hasAnyAuthority("PATRON")//Check out a video (POST)
			.antMatchers(HttpMethod.DELETE, "/checkedoutvideo/{vid}").hasAnyAuthority("PATRON")//Check in a video (DELETE)
			.anyRequest().denyAll() //Anything not declared will be denied
			.and().httpBasic()
			.and().csrf().disable();
}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	//build our custom authManager
		auth.authenticationProvider(getCustomProvider());
		
}


    @Bean
    PasswordEncoder getPasswordEncoder() {
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
