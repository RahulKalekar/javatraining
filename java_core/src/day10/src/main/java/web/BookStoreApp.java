package web;

import exceptions.DaoException;
import repository.Book;
import repository.BookDao;
import repository.BookDaoImp;
import service.BookService;
public class BookStoreApp {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImp();
        BookService bookService = new BookService(bookDao);

        try {
            Book book1 = new Book(0, "ej1", "Effective Java", "Joshua Bloch", 45.0);
            Book book2 = new Book(0, "ej2", "Head First Java", "Kathy Sierra", 40.0);
            bookService.addBook(book1);
            bookService.addBook(book2);
            System.out.println("All Books:");
            bookService.getAllBooks().forEach(System.out::println);
            book1.setTitle("Effective Java (3rd Edition)");
            bookService.updateBook(book1.getId(), book1);


            System.out.println("\nUpdated Book:");
            System.out.println(bookService.getBookById(book1.getId()));

            bookService.deleteBook(book2.getId());

            System.out.println("\nBooks After Deletion:");
            bookService.getAllBooks().forEach(System.out::println);

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
