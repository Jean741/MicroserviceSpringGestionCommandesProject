package com.ondev.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicePaymentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicePaymentApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Override
	public void run(String... args) throws Exception {		
	}

}
