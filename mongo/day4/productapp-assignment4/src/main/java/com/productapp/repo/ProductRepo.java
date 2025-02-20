package com.productapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{id :?0}") //Select * from Product where id=?
    Optional<Product> getProdcutById(Integer id);

    // SELECT * FROM Product where qty<?
    @Query("{qty : {$lt: ?0}}")
    List<Product> getProductsByQtyLessThan(Integer qty);

    // SELECT * FROM Product where qty>=?

    @Query("{ qty : { $gte: ?0 } }")
    List<Product> getProductdByPagesGreaterThanEqual(Integer qty);

    // SELECT * FROM Product where qty=?

    @Query("{ qty : ?0 }")
    List<Product> getProductsByQty(Integer pages);

    // SELECT * FROM Product where vendor = ?

    @Query("{vendor : ?0}")
    List<Product> getProductsByVendor(String vendor);

    //SELECT * FROM Product where vendor = ? and cost=?

    @Query("{vendor: ?0, cost: ?1}")
        //@Query("{$and :[{vendor: ?0},{cost: ?1}] }")
    List<Product> getProductsByVendorAndCost(String vendor, Double cost);


    //select count(*) from Product where vendor=? or name=?
    @Query("{$or :[{vendor: ?0},{name: ?1}]}")
    List<Product> getProductsByVendorOrName(String vendor, String name);

    //select count(*) from Product where vendor=?
    @Query(value ="{vendor: ?0}", count=true)
    Integer getProductsCountByVendor(String vendor);


    //Sorting
    @Query(value = "{vendor:?0}", sort= "{name:1}") //ASC
//@Query(value = "{vendor=?0}", sort= "{name:-1}") //DESC
    List<Product> getProductsByVendorSortByName(String vendor);

//@Query with Projection
    // only data of name & vendor properties will be displayed

    @Query(value= "{qty: ?0}", fields="{name:1, vendor:1}")
//@Query(value= "{qty: ?0}", fields="{name:1, vendor:1, cost:1, qty:1}") // will display all properties data
    List<Product> getProductNameAndVendorByQty(Integer qty);


    // SQL Equivalent : SELECT * FROM BOOK select * from books where author=?
    @Query(value= "{vendor : ?0}")
    List<Product> getAllProductByVendor(String vendor);


    @Query("{ vendor : { $regex : ?0 } }")
    List<Product> getProductsByVendorRegEx(String vendor);
}