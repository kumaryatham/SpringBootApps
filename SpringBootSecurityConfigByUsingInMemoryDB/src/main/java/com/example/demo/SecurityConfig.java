package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().
		withUser("Alti").
		password("Alti").
		roles("USER")
		.and()
		.withUser("Pavan")
		.password("Pavan")
		.roles("ADMIN");
		
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
	//	.antMatchers("/","static/css","static/js").permitAll()
	//	.antMatchers("/").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		//.antMatchers("/user").hasRole("USER")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin();
		
	}



	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		
	}
	

	
}
