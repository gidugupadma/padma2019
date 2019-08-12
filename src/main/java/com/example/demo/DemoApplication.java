package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		System.out.println("demo application for profiles in spring boot");
		System.out.println("demo application for profiles in spring boot");
	}
   
	
	@Profile("dev")
	@Bean
	public String devApp(){
		System.out.println("ur in dev environment");
		return "I will be available in profile dev please check the environment first while deploying code";
	}
	
	
	@Profile("qa")
	@Bean
	public String qaApp(){
		System.out.println("ur in qa environment");
		return "I will be available in profile QA";
	}
}
