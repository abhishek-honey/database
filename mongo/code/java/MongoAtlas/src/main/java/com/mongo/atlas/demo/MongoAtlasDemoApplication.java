package com.mongo.atlas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mongo"})
public class MongoAtlasDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoAtlasDemoApplication.class, args);

	}

}
