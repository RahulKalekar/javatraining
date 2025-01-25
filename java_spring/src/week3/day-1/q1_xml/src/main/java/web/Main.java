package web;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context from beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the BookService methods
        System.out.println(bookService.getAllBooks());
    }
}
