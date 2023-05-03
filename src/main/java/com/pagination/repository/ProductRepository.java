package com.pagination.repository;

import com.pagination.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p")
    List<Product> fetchAllProducts();

//    @Query("select p from Product p order by :field asc")
//    List<Product> fetchAllProductsWithSorting(@Param("field") String field);
}
