package com.book_app.services;

import com.book_app.annotations.Loggable;
import com.book_app.models.Book;
import com.book_app.repositories.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service(value = "bookService")
public class BookServiceImplementation implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    @Loggable
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        bookRepository.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

}
