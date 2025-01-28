package org.example;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks()throws DaoException;
    void addBook(Book book) throws DaoException;
    void deleteBook(int id) throws DaoException;
    void updateBook(int id, Book book) throws DaoException;
    Book getBookById(int id) throws DaoException;
}
