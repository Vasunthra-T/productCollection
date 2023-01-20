package com.quinbay.wholesaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@EnableJpaRepositories("com.quinbay.wholesaler.repository")
public class WholesalerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholesalerApplication.class, args);
	}

}
