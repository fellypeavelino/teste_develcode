package com.develcode.develcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevelcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelcodeApplication.class, args);
	}

}