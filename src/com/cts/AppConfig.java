package com.cts;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages="com.cts")
@PropertySource("a1.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	
	
	
	@Bean
	public  PropertySourcesPlaceholderConfigurer pc(){
		
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	
	
	
	@Bean
	public DataSource getDS(){
		
	System.out.println("dname is "+env.getProperty("dname"));
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/ratandb");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
	
		return dmds;
	}

}
