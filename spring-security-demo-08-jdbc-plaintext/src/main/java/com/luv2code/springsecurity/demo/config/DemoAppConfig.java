package com.luv2code.springsecurity.demo.config;


import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	
	@Autowired
	private Environment env;
	
	private Logger logger =Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	// Define a bean for security datasources
	
	@Bean
	public ComboPooledDataSource securityDataSource() {
		//create a connection pool
		ComboPooledDataSource securityDataSource =new ComboPooledDataSource();
		//set a jdbc driver class
		try {
		securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}catch(PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		//log the database connection prop
		logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));
		//set database connection pool prop
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	private int getIntProperty(String propName) {
		String propVal=env.getProperty(propName);
		
		int intpropVal=Integer.parseInt(propVal);
		return intpropVal;
			
	}
}
