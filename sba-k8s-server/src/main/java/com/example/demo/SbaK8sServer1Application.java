package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableScheduling
@EnableDiscoveryClient
public class SbaK8sServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbaK8sServer1Application.class, args);
	}

}
