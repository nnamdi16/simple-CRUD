package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}
}
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//// To support WAR file deployment
//@SpringBootApplication
//@RestController
//public class DemoApplication extends SpringBootServletInitializer implements ApplicationRunner, CommandLineRunner {
//
//	@Autowired
//	RestTemplate restTemplate;
//
//	@Value("${spring.application.name:demoWork}")
//	private String name;
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//	@RequestMapping(value = "/")
//	public String hello() {
//		return "Hello World from Tomcat";
//	}
//
//	@Bean
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}
//
//	@Override
//	public void run (ApplicationArguments arg0) throws Exception {
//		System.out.println("Hello World from Application Runner");
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Hello world from Command Line");
//	}
//}
