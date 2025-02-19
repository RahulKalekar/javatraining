package com.bookapp.repo;

import com.bookapp.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByNameAndAuthor(String name, String author);
    List<Book> findByNameOrAuthor(String name, String author);
}