package com.bookapp.service;

import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock       //Ek repo layer ka dummy bana rahe hai
    private BookRepo bookRepo;
//We have to inject that dummy also so

    @InjectMocks
    private BookServiceImpl bookService;
    private Book book;
    @BeforeEach
    void setUp() {
        book=new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00));
        bookRepo.save(book);
    }
    @DisplayName("JUnit test for getAll Books method")
    @Test
    void getAll() {
        List<Book> bookList=bookRepo.findAll();
        assertThat(bookList.size()).isEqualTo(2);
        assertThat(bookList).isNotNull();
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
    @AfterEach
    void tearDown() {
    }


}