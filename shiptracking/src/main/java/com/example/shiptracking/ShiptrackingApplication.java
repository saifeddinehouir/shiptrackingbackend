package com.example.shiptracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.shiptracking.model")  // Adjust if needed
@EnableJpaRepositories(basePackages = "com.example.shiptracking.repository")
public class ShiptrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiptrackingApplication.class, args);
	}

}
