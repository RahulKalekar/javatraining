package com.bookapp.controller;

import com.bookapp.entities.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    //get all
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());}

    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getById(id));}

    @PostMapping("books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @PutMapping("books/update/{id}")
    public Book updateBook(@PathVariable String id,@RequestBody Book book) {
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("books/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
