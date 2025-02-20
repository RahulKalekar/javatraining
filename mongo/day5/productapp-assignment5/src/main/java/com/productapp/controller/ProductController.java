package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @PostMapping("products/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(product));
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, product));
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
    @GetMapping("/quantity/greater-than/{qty}")
    public ResponseEntity<List<Product>> getProductsByQtyGreaterThan(@PathVariable int qty) {
        List<Product> products = productService.findProductsByQtysGreaterThan(qty);
        return ResponseEntity.ok(products);
    }
}