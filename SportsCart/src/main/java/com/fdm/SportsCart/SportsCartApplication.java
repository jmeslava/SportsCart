package com.fdm.SportsCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.fdm.setup", "com.fdm.controller"})
@EntityScan(basePackages = { "com.fdm.models" })
@EnableJpaRepositories(basePackages = { "com.fdm.dal" })
@SpringBootApplication
public class SportsCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsCartApplication.class, args);
	}

}
