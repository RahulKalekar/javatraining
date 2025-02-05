package com.productapp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    List<Product> getListOfAllProducts();
    @Query("select p from Product p where p.name=?1")
    List<Product> getListOfAllProductsBasedOnName(String name);
    @Query("select p from Product p where p.name=:name")
    List<Product> getListOfAllProductsBasedOnNameV2(@Param("name")  String name);


    @Query("select p from Product p where p.name=?1 and p.price=?2")
    List<Product> getListOfAllProductsBasedOnNameAndPrice(String name, BigDecimal price);

    @Query("select p from Product p where p.name=?1 or p.price=?2")
    List<Product> getListOfAllProductsBasedOnNameOrPrice(String name, BigDecimal price);


    List<Product> findByName(String name);
    //name containing

    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByNameContaining(@Param("name") String name);

    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByNameLike(@Param("name") String name);

    @Query("select p from Product p where p.name like ?1%")
    List<Product> findByNameStartingWith(@Param("name") String name);

    @Query("select p from Product p where p.name like %?1")
    List<Product> findByNameEndingWith(@Param("name") String name);

    @Query("select p from Product p where lower(p.name) = lower(?1)")
    List<Product> findByNameIgnoreCase(@Param("name") String name);

    @Query("select p from Product p where p.mfgDate > ?1")
    List<Product> findByMfgDateAfter(@Param("date") LocalDate date);

    @Query("select p from Product p where p.mfgDate < ?1")
    List<Product> findByMfgDateBefore(@Param("date") LocalDate date);

    @Query("select p from Product p where p.mfgDate between ?1 and ?2")
    List<Product> findByMfgDateBetween(@Param("date1") LocalDate date1, @Param("date2") LocalDate date);

}
