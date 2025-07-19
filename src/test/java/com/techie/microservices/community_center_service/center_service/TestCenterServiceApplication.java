package com.techie.microservices.community_center_service.center_service;

import org.springframework.boot.SpringApplication;

public class TestCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CenterServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
