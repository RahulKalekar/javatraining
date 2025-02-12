package com.bookapp.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.bookapp.entities.Book;
import com.bookapp.repo.BookRepo;
import com.bookapp.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookAppIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        bookRepo.deleteAll();
    }

    @Test
    public void givenBookObject_whenCreateBook_thenReturnSavedBook() throws Exception {

        // given - precondition or setup
        Book book = Book.builder()
                .isbn("123-4567890123")
                .title("Spring Boot Guide")
                .category("Technology")
                .author("John Doe")
                .price(new BigDecimal("29.99"))
                .build();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        // then - verify the result or output using assert statements
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.category", is(book.getCategory())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().doubleValue())));
    }

    @Test
    public void givenListOfBooks_whenGetAllBooks_thenReturnBookList() throws Exception {
        // given - precondition or setup
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(Book.builder().isbn("123-4567890123").title("Spring Boot Guide").category("Technology").author("John Doe").price(new BigDecimal("29.99")).build());
        listOfBooks.add(Book.builder().isbn("987-6543210987").title("Java Programming").category("Technology").author("Jane Smith").price(new BigDecimal("39.99")).build());
        bookRepo.saveAll(listOfBooks);

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/books"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(listOfBooks.size())));
    }

    @Test
    public void givenBookId_whenGetBookById_thenReturnBookObject() throws Exception {
        // given - precondition or setup
        Book book = Book.builder()
                .isbn("123-4567890123")
                .title("Spring Boot Guide")
                .category("Technology")
                .author("John Doe")
                .price(new BigDecimal("29.99"))
                .build();
        bookRepo.save(book);

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/books/{id}", book.getId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.category", is(book.getCategory())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice().doubleValue())));
    }

    @Test
    public void givenBookId_whenDeleteBook_thenReturn200() throws Exception {
        // given - precondition or setup
        Book book = Book.builder()
                .isbn("123-4567890123")
                .title("Spring Boot Guide")
                .category("Technology")
                .author("John Doe")
                .price(new BigDecimal("29.99"))
                .build();
        bookRepo.save(book);

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/books/{id}/delete", book.getId()));

        // then - verify the output
        response.andExpect(status().isNoContent())
                .andDo(print());
    }
}
