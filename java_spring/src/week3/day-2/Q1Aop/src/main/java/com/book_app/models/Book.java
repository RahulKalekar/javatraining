package com.book_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
}