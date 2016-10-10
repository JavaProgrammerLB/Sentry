package com.yitianyigexiangfa.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseConfig {
	
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sentry");
		dataSource.setUsername("user");
		dataSource.setPassword("pass");
		return dataSource;
	}
}
