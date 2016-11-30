package com.yitianyigexiangfa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	// 数据库登录用户名
	private String user = null;
	// 数据库登录密码
	private String pass = null;
	@Bean
	public DataSource dataSource(){
		// 创建获取数据库登录信息的属性对象
		Properties props = new Properties();
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("config/cfg.properties");
			// 加载数据
			props.load(is);
			// 获取数据
			user = props.getProperty("database.user");
			pass = props.getProperty("database.pass");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 构建数据资源对象
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sentry");
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
		return dataSource;
	}
}
