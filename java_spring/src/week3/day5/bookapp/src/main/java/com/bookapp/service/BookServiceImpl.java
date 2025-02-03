package com.bookapp.service;

import com.bookapp.aspect.Loggable;
import com.bookapp.entities.Book;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;
    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    @Loggable
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
    }

    @Override
    public Book save(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book update(int id, Book book) {
        Book bookToUpdate = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setCategory(book.getCategory());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPrice(book.getPrice());
        return bookRepo.save(bookToUpdate);
    }


    @Override
    public void delete(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
        bookRepo.delete(book);

    }
}

