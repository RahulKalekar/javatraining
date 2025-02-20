package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> getAll() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product save(Product book) {
        return mongoTemplate.insert(book);
    }

    public List<Product> saveMultiple(List<Product> products) {
        return mongoTemplate.insertAll(products).stream().toList();
    }

    @Override
    public Product update(String id, Product book) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", book.getName());
        update.set("qty", book.getQty());
        update.set("vendor", book.getVendor());
        update.set("cost", book.getCost());

        mongoTemplate.updateFirst(query, update, Product.class);

        book.setId(id);
        return book;
    }

    @Override
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Product.class);
    }

    public void findAndRemove(){
        Query query= new Query();
        query.addCriteria(Criteria.where("cost").is(1749.0));
        mongoTemplate.findAndRemove(query, Product.class);
    }
    public void deleteAllProductsCostingOver1000() {
        Query query = new Query();
        query.addCriteria(Criteria.where("cost").gte(1000));
        mongoTemplate.findAllAndRemove(query, Product.class);
    }

    @Override
    public Product getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Product product = mongoTemplate.findOne(query, Product.class);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in database");
        }
        return product;
    }

    public List<Product> findProductsByVendor(String vendor) {
        Query query = new Query(Criteria.where("vendor").is(vendor));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> findProductsByQtysGreaterThan(int qty) {

        Query query = new Query(Criteria.where("qty").gt(qty));
        return mongoTemplate.find(query, Product.class);
    }
    public void updateMulti(){
        Query query= new Query();
        query.addCriteria(Criteria.where("qty").lte(180));
        Update update = new Update();
        update.set("cost", 999.0);
        mongoTemplate.updateMulti(query, update, Product.class);
    }
    public void findAndModify(){
        Query query= new Query();
        query.addCriteria(Criteria.where("id").is("67b6f57715ee57085227b7b0"));

        Update update = new Update();
        update.set("cost", 1065.25);
        update.set("name", "Drawing set");

        mongoTemplate.findAndModify(query, update, Product.class);

        System.out.println("Data Modified");
    }


}