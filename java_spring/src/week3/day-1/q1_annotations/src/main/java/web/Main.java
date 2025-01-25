package web;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.Book;
import service.BookService;

public class Main {
    public static void main(String[] args) {
        /* //CODE FOR XML
        // Load the Spring context from beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the BookService methods
        System.out.println(bookService.getAllBooks());
        */

        //CODE FOR ANNOTATION
        ApplicationContext context = new AnnotationConfigApplicationContext(config.AppConfig.class);

        BookService bookService = context.getBean(BookService.class);

        // Test getAllBooks
        System.out.println("Books: " + bookService.getAllBooks());

        // Test addBook
        Book newBook = new Book(0, "XYZ123", "Effective Java", "Joshua Bloch", 800);
        bookService.addBook(newBook);
        System.out.println("After Adding Book: " + bookService.getAllBooks());


    }
}


