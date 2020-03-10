package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource dataSource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(this.dataSource)
		.withDefaultSchema()
		.withUser(User.withUsername("user").password("pass").roles("USER"))
		.withUser(User.withUsername("admin").password("pass").roles("ADMIN"));; 
		
		/*
		 * auth.jdbcAuthentication().dataSource(this.dataSource)
		 * .usersByUsernameQuery("select * from username,password,enabled" +
		 * " from users" + "where username=?")
		 * .authoritiesByUsernameQuery("select * from username,authority" +
		 * " from authorities" + "where username=?");
		 */
		
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/h2-console").permitAll()
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
