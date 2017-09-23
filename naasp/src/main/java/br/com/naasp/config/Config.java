package br.com.naasp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.naasp.controllers", "br.com.naasp.daos" })
@EntityScan(basePackages = { "br.com.naasp.models" })
public class Config {
	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}

}
