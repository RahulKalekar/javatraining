package com.book_app;

import com.book_app.services.BookService;
import com.config.AutoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        BookService bs = (BookService) context.getBean("bookService");
        bs.deleteBook(1);
        System.out.println(bs.getAllBooks());
    }
}