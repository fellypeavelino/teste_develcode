package com.develcode.develcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevelcodeApplication {

	public static void main(String[] args) {
            NodeStarter n = new NodeStarter();
            n.startNodeServer();
            SpringApplication.run(DevelcodeApplication.class, args);
	}

}
