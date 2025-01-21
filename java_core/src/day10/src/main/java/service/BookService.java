package service;

import exceptions.DaoException;
import repository.Book;
import repository.BookDao;

import java.util.*;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() throws DaoException {
        return bookDao.getAllBooks();
    }

    public Book addBook(Book book) throws DaoException {
        return bookDao.addBook(book);
    }

    public void deleteBook(int id) throws DaoException {
        bookDao.deleteBook(id);
    }

    public void updateBook(int id, Book book) throws DaoException {
        bookDao.updateBook(id, book);
    }

    public Book getBookById(int id) throws DaoException {
        return bookDao.getBookById(id);
    }
}
