package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableAutoConfiguration
public class SbaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbaServerApplication.class, args);
	}

}
