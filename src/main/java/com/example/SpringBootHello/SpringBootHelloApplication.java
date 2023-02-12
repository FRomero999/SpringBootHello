package com.example.SpringBootHello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="models")
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}

}
