package com.infubuzz.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.infybuzz.controller", "com.infybuzz.service"})
@EntityScan("com.infybuzz.entity")
@EnableJpaRepositories("com.infybuzz.repository")
public class AssasmentWeek4Q16Application { 
	
	@Value("${customer.service.url}")
	private String customerServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(AssasmentWeek4Q16Application.class, args); 
	}
	
	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl(customerServiceUrl)
				.build();

		return webClient;
	}

}
