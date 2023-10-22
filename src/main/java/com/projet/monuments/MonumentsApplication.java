package com.projet.monuments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@SpringBootApplication
public class MonumentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentsApplication.class, args);
	}

}
