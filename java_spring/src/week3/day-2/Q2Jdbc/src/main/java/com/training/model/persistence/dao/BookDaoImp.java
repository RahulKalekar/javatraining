package com.training.model.persistence.dao;


import com.training.model.annotations.Loggable;
import com.training.model.persistence.entities.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;


@Component
public class BookDaoImp implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "select * from book_table";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book addBook(Book book) {
        String sql = "insert into book_table(isbn, title, author, price) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice());
        return book;
    }

    @Override
    public void deleteBook(int id) {
        String sql = "delete from book_table where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateBook(int id, Book book) {
        String sql = "update book_table set isbn = ?, title = ?, author = ?, price = ? where id = ?";
        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), id);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from book_table where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
