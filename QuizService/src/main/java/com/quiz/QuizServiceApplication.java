package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Quiz-Application",
				version = "2.0.2",
				description = "This is my Quiz-Application",
				termsOfService = "myterms",
				contact = @Contact(
						name = "VinayKumarYadav",
						email = "vinayyadav91190@gmail.com"),
				license = @License(
						name = "MyLicense",
						url= "myterms")
				))

public class QuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

}
