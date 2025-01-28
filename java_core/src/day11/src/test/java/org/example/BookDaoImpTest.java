package org.example;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoImpTest {

    private static BookDao bookDao;


    @BeforeAll
    static void setup() {
        // Initialize the DAO before running tests
        bookDao = new BookDaoImp();
    }

    @Test
    @Order(1)
    void testAddBook() throws DaoException {
        Book book = new Book( "978-0134685991", "Effective Java", "Joshua Bloch", 45.00);
        Book addedBook = bookDao.addBook(book);

        assertEquals(book.getTitle(), addedBook.getTitle(), "Book title should match");
    }

    @Test
    @Order(2)
    void testGetAllBooks() throws DaoException {

        bookDao.addBook(new Book( "978-0134685991", "Effective Java", "Joshua Bloch", 45.00));

        List<Book> books = bookDao.getAllBooks();
        System.out.println(books);
        assertEquals(2, books.size(), "There should be 2 books in the database");
    }



    @Test
    @Order(3)
    void testUpdateBook() throws DaoException {
        Book book = new Book( "978-0134685991", "Effective Java", "Joshua Bloch", 45.00);
        Book addedBook = bookDao.addBook(book);

        addedBook.setPrice(50.00);
        bookDao.updateBook(addedBook.getId(), addedBook);

        Book updatedBook = bookDao.getBookById(addedBook.getId());
        assertEquals(50.00, updatedBook.getPrice(), "Book price should be updated");
    }

    @Test
    @Order(4)
    void testDeleteBook() throws DaoException {
        Book book = new Book( "978-0134685991", "Effective Java", "Joshua Bloch", 45.00);
        Book addedBook = bookDao.addBook(book);

        bookDao.deleteBook(addedBook.getId());

        Book deletedBook = bookDao.getBookById(addedBook.getId());
        assertNull(deletedBook, "Deleted book should not exist");
    }

    @Test
    @Order(5)
    void testGetBookById() throws DaoException {
        Book book = new Book( "978-0134685991", "Effective Java", "Joshua Bloch", 45.00);
        Book addedBook = bookDao.addBook(book);

        Book fetchedBook = bookDao.getBookById(addedBook.getId());
        assertNotNull(fetchedBook, "Fetched book should exist");
        assertEquals(addedBook.getTitle(), fetchedBook.getTitle(), "Book title should match");
    }
}
