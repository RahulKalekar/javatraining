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
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock       //Ek repo layer ka dummy bana rahe hai
    private BookRepo bookRepo;
//We have to inject that dummy also so


    //ALso notice in every method we using service layer's bookService
    //Hence DB is not used actually
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
        Book book2=new Book("123","book2","category2","author2", BigDecimal.valueOf(2000.00));
        given(bookRepo.findAll()).willReturn(List.of(book,book2));
        List<Book> bookList=bookService.getAll();
        assertThat(bookList.size()).isEqualTo(2);
        assertThat(bookList).isNotNull();
    }

    @DisplayName("JUnit test for getBookById method")
    @Test
    void getById() {
        when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        Book foundBook = bookService.getById(1);

        assertThat(foundBook.getIsbn()).isEqualTo("123");
    }

    @DisplayName("JUnit test for save Book method")
    @Test
    void save() {
        when(bookRepo.save(book)).thenReturn(book);
        Book savedBook = bookService.save(book);
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
    }

    @DisplayName("JUnit test for update Book method")
    @Test
    void update() {
        // Arrange: Mocking the findById and save methods
        when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        when(bookRepo.save(book)).thenReturn(book);

        Book updatedBook = bookService.update(1, book);
        assertThat(updatedBook.getIsbn()).isEqualTo("123");
    }

    @DisplayName("JUnit test for delete Book method")
    @Test
    void delete() {
    }
    @AfterEach
    void tearDown() {
    }


}