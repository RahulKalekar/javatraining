package com.productapp;

import com.productapp.repo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String name, Integer qty, String vendor, Double cost

		//insert();
	}

	private void insert() {
		System.out.println("------------------------");
	}
}
