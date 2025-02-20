package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCustomController {
    private ProductService productService;

    @Autowired
    public ProductCustomController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("hello")
    public String getHello(){
        return "Hekko";
    }
    //products by vendor or name
    @GetMapping("custom/{vendor}/{name}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable String vendor, @PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByVendorOrName(vendor, name));
    }
    @GetMapping("custom/vendor/{vendor}/count")
    public ResponseEntity<Integer> getProductsCountByVendor(@PathVariable String vendor) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsCountByVendor(vendor));
    }

    @GetMapping("custom/vendor/{vendor}/sort")
    public ResponseEntity<List<Product>> getProductsByVendorSortByName(@PathVariable String vendor) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByVendorSortByName(vendor));
    }

}
