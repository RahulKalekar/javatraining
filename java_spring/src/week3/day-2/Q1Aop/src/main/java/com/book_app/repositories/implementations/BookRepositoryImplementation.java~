package com.book_app.repositories.implementations;

import com.book_app.models.Book;
import com.book_app.repositories.BookRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository(value = "bookRepository")
@Primary
class bookRepositoryMapImplementation implements BookRepository {
    private static final Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
    private static int counter = 0;
    static {
        booksMap.put(++counter, new Book(counter, "ABC123", "Head first Java" , "Katthy", 600));
        booksMap.put(++counter,  new Book(counter, "ABC723", "Servlet jsp Java" , "Katthy", 700));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return booksMap.get(counter);
    }

    @Override
    public void deleteBook(int id) {
        booksMap.remove(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }
}

