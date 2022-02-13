package com.ondev.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ondev.product.dao.ProductRepository;
import com.ondev.product.entities.Product;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceProductApplication implements CommandLineRunner{

	@Autowired
	ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProductApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
	productRepository.save(Product.builder().name("Coca").price(15).quantity(5).build());
	productRepository.save(Product.builder().name("Anana").price(14).quantity(2).build());
	}

}
