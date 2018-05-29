package com.standup.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@PropertySource(value = { "classpath:application.properties" })
//@ComponentScan("{com.standup.controller, com.standup.dao, com.standup.model, com.standup.swagger}")
//@ComponentScan(basePackageClasses = StandupController.class)
@ComponentScan("com.standup.controller")
@EnableMongoRepositories("com.standup")
//@ComponentScan(basePackageClasses = {StandupC,ontroller.class, StandupRepository.class})
@SpringBootApplication
public class StandupApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandupApplication.class, args);
	}
	
	
}
