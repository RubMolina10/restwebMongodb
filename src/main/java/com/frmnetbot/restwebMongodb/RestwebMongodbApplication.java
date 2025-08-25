package com.frmnetbot.restwebMongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class RestwebMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestwebMongodbApplication.class, args);
	}

}
