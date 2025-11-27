package com.example.appA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppAApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppAApplication.class, args);


	}

}
