package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String name, Integer qty, String vendor, Double cost

		//insert();
	}

	private void insert() {
		productRepo.save(new Product("dell laptop", 30, "AB electronic", 5000000.0));
		productRepo.save(new Product("mouse", 300, "MA electronic", 500.0));
		productRepo.save(new Product("Keyboard", 20, "ZA electronic", 600.0));
		System.out.println("------------------------");
	}
}
