package com.zensar.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// use for authentication purpose

		auth.userDetailsService(userDetailsService);

		
		 auth.inMemoryAuthentication() .withUser("ram") .password("ram@123")
		 .roles("USER") .and() .withUser("laxman") .password("laxman@123")
		  .roles("ADMIN");
		 
	}	*/

/*	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// use for authorization purpose

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().oauth2Login();

	}

/*	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/

}
