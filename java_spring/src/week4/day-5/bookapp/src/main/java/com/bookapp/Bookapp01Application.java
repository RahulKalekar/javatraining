package com.bookapp;

import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
@SpringBootApplication
public class Bookapp01Application implements CommandLineRunner {
    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(Bookapp01Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        //bookRepo.save(new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00)));
        //bookRepo.save(new Book("456","book2","category2","author2",BigDecimal.valueOf(2000.00)));
        System.out.println("---------------added books----------------");
    }
}
