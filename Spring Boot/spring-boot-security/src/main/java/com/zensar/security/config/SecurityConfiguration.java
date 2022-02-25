package com.zensar.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// use for authentication purpose

		auth.userDetailsService(userDetailsService);

		/*
		 * auth.inMemoryAuthentication() .withUser("ram") .password("ram@123")
		 * .roles("USER") .and() .withUser("laxman") .password("laxman@123")
		 * .roles("ADMIN");
		 */
	}

	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// use for authorization purpose

		http.csrf().disable().
		authorizeRequests().
		antMatchers("/admin").hasRole("ADMIN").
		antMatchers("/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/all", "/authenticate").permitAll()
		.and()
		//.httpBasic()
		.formLogin();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
