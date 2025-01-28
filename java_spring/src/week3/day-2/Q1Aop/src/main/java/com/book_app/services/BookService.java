package com.book_app.services;

import com.book_app.models.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    Book getBookById(int id);

}
