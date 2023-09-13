package com.test.fhf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class FirstHelpFinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstHelpFinancialApplication.class, args);
	}

	@Value("${baseURL}")
	private String baseURL;

	@Bean
	public WebClient webClient() {

		WebClient webClient = WebClient.builder()
										.baseUrl(baseURL)
										.build();
		return webClient;
	}

}
