package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {
	private final ProductRepo productRepo;
	@Autowired
    public ProductappApplication(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product(1L, "Apple iPhone 14", new BigDecimal("999.99"), LocalDate.of(2024, 1, 1)));
		productRepo.save(new Product(2L, "Samsung Galaxy S22", new BigDecimal("849.99"), LocalDate.of(2024, 2, 1)));
		productRepo.save(new Product(3L, "Sony WH-1000XM5 Headphones", new BigDecimal("349.99"), LocalDate.of(2024, 3, 1)));
		productRepo.save(new Product(4L, "Dell XPS 13 Laptop", new BigDecimal("1299.99"), LocalDate.of(2024, 4, 1)));
		productRepo.save(new Product(5L, "Apple Watch Series 8", new BigDecimal("399.99"), LocalDate.of(2024, 5, 1)));
		productRepo.save(new Product(6L, "Google Pixel 7", new BigDecimal("599.99"), LocalDate.of(2024, 6, 1)));
		productRepo.save(new Product(7L, "Bose SoundLink Revolve+ Bluetooth Speaker", new BigDecimal("399.00"), LocalDate.of(2024, 7, 1)));
		productRepo.save(new Product(8L, "Microsoft Surface Pro 9", new BigDecimal("1099.99"), LocalDate.of(2024, 8, 1)));
		productRepo.save(new Product(9L, "Samsung QLED 4K TV", new BigDecimal("1199.99"), LocalDate.of(2024, 9, 1)));
		productRepo.save(new Product(10L, "Canon EOS R6 Camera", new BigDecimal("2499.99"), LocalDate.of(2024, 10, 1)));

	}
}
