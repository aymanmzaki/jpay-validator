package com.jumia.jpay.jpayvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class JpayValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpayValidatorApplication.class, args);
	}

}
