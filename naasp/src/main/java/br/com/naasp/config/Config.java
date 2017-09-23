package br.com.naasp.config;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.naasp.controllers", "br.com.naasp.daos" })
// @EntityScan(basePackages = { "br.com.naasp.models" })
public class Config {
	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(
				"jdbc:sqlserver://naasp.database.windows.net:1433;database=naasp;user=tomcat;password=Root@123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return dataSource;
	}
}
