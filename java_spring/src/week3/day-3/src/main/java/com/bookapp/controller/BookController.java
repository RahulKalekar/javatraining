package com.bookapp.controller;

import com.bookapp.entities.Book;
import com.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }
    @GetMapping(path="books/{id}")           //READ (R)
    public Book getById(@PathVariable int id){
        return bookService.getById(id);
    }
    @PostMapping(path="books/save")         //CREATE (C)
    public ResponseEntity<Book> save(@Valid @RequestBody Book book){
        Book bookToAdd=bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookToAdd);
    }
    @PutMapping(path="books/{id}/update")      //UPDATE (U)
    public ResponseEntity<Book> update(@PathVariable int id,@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(id, book));
    }
    @DeleteMapping("books/{id}/delete")         //DELETE (D)
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
