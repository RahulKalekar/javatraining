package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
//    http://localhost:8080/products/name?name=
//    http://localhost:8080/products/name-contain?name=
//    http://localhost:8080/products/name-like?name=
//    http://localhost:8080/products/name-starting?name=
//    http://localhost:8080/products/name-ending?name=
//    http://localhost:8080/products/name-ignore-case?name=
//    http://localhost:8080/products/mfg-date-after?date=2023-01-01
//    http://localhost:8080/products/mfg-date-before?date=2023-01-01
//    http://localhost:8080/products/mfg-date-between?date1=2023-01-01&date2=2023-12-31
    @Autowired
    private ProductService productService;
    @GetMapping("/name-price")
    public List<Product> getProductsByNameAndPrice(@RequestParam String name, @RequestParam BigDecimal price) {
        return productService.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }
    @GetMapping("/name")
    public List<Product> getListOfAllProductsBasedOnNameV2(@RequestParam String name) {
        return productService.getListOfAllProductsBasedOnNameV2(name);
    }
    @GetMapping("/name/{name}")
    public List<Product> getListOfAllProductsBasedOnName(@PathVariable String name) {
        return productService.getListOfAllProductsBasedOnName(name);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getListOfAllProducts());
    }
    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }
    @GetMapping("/sorted")
    public List<Product> getAllProductSorted(@RequestParam String field) {
        return productService.getAllProductSorted(field);
    }

    @GetMapping("/page")
    public Page<Product> getAllProductPage(@RequestParam int offset, @RequestParam int pageSize) {
        return productService.getAllProductPage(offset, pageSize);
    }

    @GetMapping("/pagesorted")
    public Page<Product> getAllProductPageSorted(@RequestParam int offset, @RequestParam int pageSize, @RequestParam String field) {
        return productService.getAllProductPageSorted(field, offset, pageSize);
    }
    @GetMapping("/name-contain")
    public List<Product> getProductsByNameContaining(@RequestParam String name) {
        return productService.findByNameContaining(name);
    }

    @GetMapping("/name-like")
    public List<Product> getProductsByNameLike(@RequestParam String name) {
        return productService.findByNameLike(name);
    }

    @GetMapping("/name-starting")
    public List<Product> getProductsByNameStartingWith(@RequestParam String name) {
        return productService.findByNameStartingWith(name);
    }

    @GetMapping("/name-ending")
    public List<Product> getProductsByNameEndingWith(@RequestParam String name) {
        return productService.findByNameEndingWith(name);
    }

    @GetMapping("/name-ignore-case")
    public List<Product> getProductsByNameIgnoreCase(@RequestParam String name) {
        return productService.findByNameIgnoreCase(name);
    }

    @GetMapping("/mfg-date-after")
    public List<Product> getProductsByMfgDateAfter(@RequestParam LocalDate date) {
        return productService.findByMfgDateAfter(date);
    }

    @GetMapping("/mfg-date-before")
    public List<Product> getProductsByMfgDateBefore(@RequestParam LocalDate date) {
        return productService.findByMfgDateBefore(date);
    }

    @GetMapping("/mfg-date-between")
    public List<Product> getProductsByMfgDateBetween(@RequestParam LocalDate date1, @RequestParam LocalDate date2) {
        return productService.findByMfgDateBetween(date1, date2);
    }

}
