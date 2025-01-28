package com.training.model.persistence.dao;

import com.training.model.annotations.Loggable;
import com.training.model.persistence.entities.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    Book addBook(Book book);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    Book getBookById(int id);
}
