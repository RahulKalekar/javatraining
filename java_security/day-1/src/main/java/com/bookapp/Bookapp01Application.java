package com.bookapp;

import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import com.bookapp.repo.UserEntity;
import com.bookapp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class Bookapp01Application implements CommandLineRunner {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserEntityService userEntityService;
    public static void main(String[] args) {
        SpringApplication.run(Bookapp01Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
//        userEntityService.addUserEntity(new UserEntity("teacher",
//                passwordEncoder.encode("teacher"), List.of("ROLE_TEACHER","ROLE_STUDENT")));
//
//        userEntityService.addUserEntity(new UserEntity("student",passwordEncoder.encode("student"),
//                List.of("ROLE_STUDENT")));
        bookRepo.save(new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00)));
        bookRepo.save(new Book("456","book2","category2","author2",BigDecimal.valueOf(2000.00)));
        System.out.println("---------------added books----------------");
    }
}
