package com.StableManagement.stable_management_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class StableManagementSystemApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(StableManagementSystemApiApplication.class, args);
	}
}
