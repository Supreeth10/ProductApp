package com.example.ProductApp;

import com.example.ProductApp.product.Product;
import com.example.ProductApp.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			Product product = new Product();
			product.setId(UUID.fromString("4af608e6-336c-4aad-b0e5-7351c6720284"));
			product.setName("MacBook Pro");
			product.setDescription("MacBook Pro");
			product.setPrice(new BigDecimal(3000));
			product.setStockLevel(100);
			productRepository.save(product);
		};
	}

}
