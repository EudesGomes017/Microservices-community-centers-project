package com.techie.microservices.community_center_service.center_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class CenterServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
