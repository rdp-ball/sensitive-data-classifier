package com.aurva.rolwin.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.aurva"})
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.aurva"})
@EntityScan(basePackages = {"com.aurva"})

public class AurvaRolwinAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AurvaRolwinAssignmentApplication.class, args);
	}

}
