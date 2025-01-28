package com.training.model.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    // Getters and Setters
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
}
