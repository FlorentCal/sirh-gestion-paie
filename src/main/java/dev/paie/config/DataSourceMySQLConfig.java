package dev.paie.config;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dev.paie.util.URLBuilder;

@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.util"})
public class DataSourceMySQLConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		ResourceBundle resourceBundle = ResourceBundle.getBundle("app");

		String typeBase = resourceBundle.getString("typeBase");
		String localhost = resourceBundle.getString("localhost");
		String nomBase = resourceBundle.getString("nomBase");
		String username = resourceBundle.getString("userName");
		String password = resourceBundle.getString("password");

		dataSource.setUrl(URLBuilder.build(typeBase, localhost, nomBase));
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}