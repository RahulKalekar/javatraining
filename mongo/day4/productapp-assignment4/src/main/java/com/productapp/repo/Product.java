package com.productapp.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private Integer qty;
    private String vendor;
    private Double cost;

    public Product(String name, Integer qty, String vendor, Double cost) {
        this.name = name;
        this.qty = qty;
        this.vendor = vendor;
        this.cost = cost;
    }
}