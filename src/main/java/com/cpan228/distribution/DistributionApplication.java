package com.cpan228.distribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributionApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DistributionApplication.class);
		app.setAdditionalProfiles("dev"); // Change to "qa" for QA profile
		app.run(args);
	}
}
