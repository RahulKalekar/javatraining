package com.bookapp.controller;

import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import com.bookapp.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Book book = new Book("12345678", "Test Book", "Fiction", "Test Author", BigDecimal.valueOf(1000.00));

        given(bookService.save(any(Book.class))).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().doubleValue())));
    }

    @Test
    public void givenListOfBooks_whenGetAllBooks_thenReturnBookList() throws Exception {
        List<Book> books = Arrays.asList(
                new Book("12345678", "Book One", "Fiction", "Author One", BigDecimal.valueOf(1000.00)),
                new Book("98765432", "Book Two", "Drama", "Author Two", BigDecimal.valueOf(2000.00))
        );

        given(bookService.getAll()).willReturn(books);

        ResultActions response = mockMvc.perform(get("/api/books"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(books.size())));
    }

    @Test
    public void givenBookId_whenGetBookById_thenReturnBookObject() throws Exception {
        int bookId = 1;
        Book book = new Book("12345678", "Test Book", "Fiction", "Test Author", BigDecimal.valueOf(1000.00));

        given(bookService.getById(bookId)).willReturn(book);

        ResultActions response = mockMvc.perform(get("/api/books/{id}", bookId));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().doubleValue())));
    }

    @Test
    public void givenBookIdAndBookObject_whenUpdateBook_thenReturnUpdatedBook() throws Exception {
        int bookId = 1;
        Book book = new Book("12345678", "Updated Book", "Drama", "Updated Author", BigDecimal.valueOf(1000.00));

        given(bookService.update(bookId, book)).willReturn(book);

        ResultActions response = mockMvc.perform(put("/api/books/{id}/update", bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().doubleValue())));
    }

    @Test
    public void givenBookId_whenDeleteBook_thenReturnNoContent() throws Exception {
        int bookId = 1;
        willDoNothing().given(bookService).delete(bookId);

        ResultActions response = mockMvc.perform(delete("/api/books/{id}/delete", bookId));

        response.andExpect(status().isNoContent())
                .andDo(print());
    }
}
