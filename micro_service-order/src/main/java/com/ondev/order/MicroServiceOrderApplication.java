package com.ondev.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ondev.order.dao.OrderRepository;
import com.ondev.order.entities.Order;

@SpringBootApplication
public class MicroServiceOrderApplication implements CommandLineRunner{

	@Autowired
	OrderRepository orderRepository;
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOrderApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	@Override
	public void run(String... args) throws Exception {
//		orderRepository.saveAndFlush(Order.builder()
//				.number(1253565156465L)
//				.
//				.build());		
	}
}
