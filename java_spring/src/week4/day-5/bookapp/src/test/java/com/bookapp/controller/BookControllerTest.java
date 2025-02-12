package com.bookapp.controller;

import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import com.bookapp.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    @MockBean
    private BookRepo bookRepo;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenBookObject_whenCreateBook_thenReturnSavedBook() throws Exception {
        // given - precondition or setup
        Book book = new Book("123", "book1", "category1", "author1", BigDecimal.valueOf(1000.00));
        given(bookService.save(any(Book.class))).willReturn(book);  // Mock the save() method

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        // then - verify the result or output using assert statements
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle()))) // Adjust to 'title'
                .andExpect(jsonPath("$.category", is(book.getCategory())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().toString())));  // Adjust for BigDecimal
    }

}