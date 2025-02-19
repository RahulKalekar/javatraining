package com.bookapp.service;

import com.bookapp.entities.Book;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.repo.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(String id) {
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("book not found"));
    }

    @Override
    public Book updateBook(String id,Book book) {
        Book toUpdate = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("book not found"));
        toUpdate.setName(book.getName());
        toUpdate.setPages(book.getPages());
        toUpdate.setAuthor(book.getAuthor());
        toUpdate.setCost(book.getCost());
        bookRepository.save(toUpdate);
        return toUpdate;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
