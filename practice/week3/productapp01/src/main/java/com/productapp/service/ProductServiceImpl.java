package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        if(1==1)
            throw  new RuntimeException("some jdbc code failed");
        return productRepo.getProducts();
    }

    @Override
    public Product getProductById(int id) {
         return productRepo.getById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.addProduct(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productRepo.updateProduct(id, product);
    }

    @Override
    public Product removeProduct(int id) {
        return productRepo.removeProduct(id);
    }
}
