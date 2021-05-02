package com.buildown.microservice.buildowncompanyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({ "com.buildown" })
public class BuildownCompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildownCompanyServiceApplication.class, args);
	}

}
