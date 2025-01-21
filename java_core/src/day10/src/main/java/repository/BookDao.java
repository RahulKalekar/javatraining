package repository;

import exceptions.DaoException;

import java.util.List;


public interface BookDao {
    List<Book> getAllBooks() throws DaoException;
    Book addBook(Book book) throws DaoException;
    void deleteBook(int id) throws DaoException;
    void updateBook(int id, Book book) throws DaoException;
    Book getBookById(int id) throws DaoException;
}
