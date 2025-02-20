package com.productapp.service;

import com.productapp.repo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product save(Product book);
    public Product update(String id, Product book);
    public void delete(String id);
    public Product getById(String id);
}
