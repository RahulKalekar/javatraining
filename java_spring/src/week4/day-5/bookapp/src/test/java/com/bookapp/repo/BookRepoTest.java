package com.bookapp.repo;

import com.bookapp.entities.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepoTest {
    @Autowired
    private BookRepo bookRepo;
    private Book book;
    @BeforeEach
    void setUp() {
        book=new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00));
    }

    @DisplayName("given Book Object When Saved Then Return Book Object")
    @Test
    @Rollback(value = true)
    public void givenProductObjectWhenSavedThenRetunProductObject(){
        Book savedBook= bookRepo.save(book);
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @DisplayName("givenBookListWhenFindAllThenReturnBookList")
    @Test
    public void givenBookListWhenFindAllThenReturnBookList(){
        //given
        Book book=new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00));

        bookRepo.save(book);
        bookRepo.save(book);
        //when
        List<Book> bookList=bookRepo.findAll();
        //then verify
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isEqualTo(1);
    }

    @AfterEach
    void tearDown() {
    }
}