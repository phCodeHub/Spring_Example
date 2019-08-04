package com.code.security.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.code.security")
@PropertySource("classpath:persistence-mysql.properties")
public class DemAppConfig {
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource secDataSource = new ComboPooledDataSource();
		
		
		try {
			secDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("URL >>> "+env.getProperty("jdbc.url"));
		logger.info("URL >>> "+env.getProperty("jdbc.user"));
		logger.info("URL >>> "+env.getProperty("jdbc.password"));
		
		secDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		secDataSource.setUser(env.getProperty("jdbc.user"));
		secDataSource.setPassword(env.getProperty("jdbc.password"));
		
		secDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		secDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		secDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		secDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return secDataSource;
	}
	
	private int getIntProperty(String propName) {
		
		return Integer.parseInt(env.getProperty(propName));
	}
}
