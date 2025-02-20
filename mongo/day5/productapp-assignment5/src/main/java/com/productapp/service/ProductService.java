package com.productapp.service;

import com.productapp.repo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product save(Product book);
    public Product update(String id, Product book);
    public void delete(String id);
    public Product getById(String id);
    public void findAndModify();
    public void updateMulti();
    public List<Product> findProductsByQtysGreaterThan(int qty);
    public List<Product> findProductsByVendor(String vendor);
    public void deleteAllProductsCostingOver1000();
    public void findAndRemove();
}
