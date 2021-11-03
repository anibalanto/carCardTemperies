package com.temperies.carcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Original creator by rajeevkumarsingh on 27/06/17.
 * Edited by anibal.anto for DH
 */

@SpringBootApplication
@EnableJpaAuditing
public class CarCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCardApplication.class, args);
	}
}
