package com.programming.techie.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.cloudyrock.spring.v5.EnableMongock;

@SpringBootApplication
@EnableMongock
public class TestMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMongoDbApplication.class, args);
	}

}
