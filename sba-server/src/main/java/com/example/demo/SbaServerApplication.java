package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.web.client.InstanceExchangeFilterFunction;

@SpringBootApplication
@EnableAdminServer
@EnableConfigServer
public class SbaServerApplication {

	private static final Logger log = LoggerFactory.getLogger(SbaServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SbaServerApplication.class, args);
	}

	
	@Bean
	public InstanceExchangeFilterFunction auditLog() {
		return (instance, request, next) -> next.exchange(request).doOnSubscribe((s) -> {
			if (HttpMethod.DELETE.equals(request.method()) || HttpMethod.POST.equals(request.method())) {
				log.info("{} for {} on {}", request.method(), instance.getId(), request.url());
			}
		});
	}
}
