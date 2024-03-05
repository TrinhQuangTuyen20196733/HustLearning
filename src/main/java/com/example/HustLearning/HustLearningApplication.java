package com.example.HustLearning;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@OpenAPIDefinition(
		info = @Info(
				title = "Hust Learning API",
				version = "1.0.0",
				description = "Building Hust Learning platform",
				contact = @Contact(
						name = "Trịnh Quang Tuyến",
						email = "tuyen.tq196733@sis.hust.edu.vn"
				)
		)
)
public class HustLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HustLearningApplication.class, args);
	}




}
