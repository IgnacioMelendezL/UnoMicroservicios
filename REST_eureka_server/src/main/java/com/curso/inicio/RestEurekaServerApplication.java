package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RestEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEurekaServerApplication.class, args);
	}

}
