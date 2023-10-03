package com.freshapples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * Main function of application, runs spring boot application.
 * 
 * Application is an e-commerce web-site for digital movies. 
 * It implements a login, registration, home, and products page.
 * Styling is done with Thymeleaf, bootstrap, and basic CSS.
 * 
 * */
@ComponentScan({"com.freshapples"})
@ComponentScan(basePackageClasses=com.freshapples.controllers.OrdersController.class)
// @EnableJpaRepositories("com.freshapples.*")
// @EntityScan("com.freshapples.*")
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		//DISPLAY BEANS UNCOMMENT
		//ConfigurableApplicationContext app = 
		//Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
		
	}

}