package com.book_app.repositories;

import com.book_app.models.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    Book addBook(Book book);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    Book getBookById(int id);
}
