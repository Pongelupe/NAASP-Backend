package br.com.naasp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.naasp.controllers" })
@EntityScan(basePackages = { "br.com.naasp.models" })
@EnableJpaRepositories(basePackages = { "br.com.naasp.repository" })
public class Config {

	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}
}
