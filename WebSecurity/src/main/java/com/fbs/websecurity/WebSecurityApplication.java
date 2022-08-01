package com.fbs.websecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSecurityApplication.class, args);
		
		System.out.println("Web-Security Service is Started");
	}

}
