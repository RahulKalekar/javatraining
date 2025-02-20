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
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product book) {
        return productRepo.save(book);
    }

    @Override
    public Product update(String id, Product book) {
        book.setId(id);
        productRepo.save(book);
        return book;
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id:"+id+"is not present"));
    }
    @Override
    public List<Product> getProductsByVendorOrName(String vendor, String name) {
        return productRepo.getProductsByVendorOrName(vendor, name);
    }

    @Override
    public int getProductsCountByVendor(String vendor) {
        return productRepo.getProductsCountByVendor(vendor);
    }

    @Override
    public List<Product> getProductsByVendorSortByName(String vendor) {
        return productRepo.getProductsByVendorSortByName(vendor);
    }
}