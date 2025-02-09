package com.bookapp.controller;

import com.bookapp.Dto.AuthRequest;
import com.bookapp.config.JwtService;
import com.bookapp.entities.Book;
import com.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api")
@Validated
public class BookController {

    private BookService bookService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }
    //TO CHECK METHOD LEVEL SECURITY I HAVE GIVEN SIMPLY
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @GetMapping(path="books/{id}")           //READ (R)
    public Book getById(@PathVariable int id){
        return bookService.getById(id);
    }
    @PostMapping(path="books/save")         //CREATE (C)
    public ResponseEntity<Book> save(@Valid @RequestBody Book book){
        Book bookToAdd=bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookToAdd);
    }
    @PostMapping(path = "authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication
                =authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                ));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw  new UsernameNotFoundException("user is invalid");
        }


    }
    @PutMapping(path="books/update/{id}")      //UPDATE (U)
    public ResponseEntity<Book> update(@PathVariable int id,@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(id, book));
    }
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @DeleteMapping("books/delete/{id}")         //DELETE (D)
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
