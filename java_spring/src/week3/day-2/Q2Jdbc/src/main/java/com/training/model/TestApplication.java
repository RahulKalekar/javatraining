package com.training.model;

import com.training.model.config.AppConfig;
import com.training.model.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService service = context.getBean(BookService.class);

        service.getAllBooks()
                .forEach(book -> System.out.println(book.getTitle()));

        service.deleteBook(2);

        service.getAllBooks()
                .forEach(book -> System.out.println(book.getTitle()));

    }
}
