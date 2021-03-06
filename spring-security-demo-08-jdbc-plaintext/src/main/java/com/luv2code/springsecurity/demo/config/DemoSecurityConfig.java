package com.luv2code.springsecurity.demo.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add a refrence to our security data source 
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		UserBuilder users=User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser(users.username("dhiraj").password("test123").roles("EMPLOYEE"))
//		.withUser(users.username("MANISH").password("test123").roles("EMPLOYEE","MANAGER"))
//		.withUser(users.username("MOHAN").password("test123").roles("EMPLOYEE","ADMIN"));
		auth.jdbcAuthentication().dataSource((javax.sql.DataSource) securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("EMPLOYEE")
		.antMatchers("/systems/**").hasRole("EMPLOYEE")
		.and().formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
