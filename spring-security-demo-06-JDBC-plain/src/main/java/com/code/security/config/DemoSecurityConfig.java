package com.code.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		/*http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		.loginPage("/showLoginPage").loginProcessingUrl("/authenticateUser").
		permitAll().and().logout().permitAll();*/
		
		
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin()
		.loginPage("/showLoginPage").loginProcessingUrl("/authenticateUser").
		permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
		
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		/*
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("Pulkit").password("1234").roles("Employee","ADMIN"))
		.withUser(users.username("Pintu").password("1234").roles("Employee","Manager"))
		.withUser(users.username("Deep").password("1234").roles("Employee"));*/
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	

}
