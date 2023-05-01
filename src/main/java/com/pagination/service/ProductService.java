package com.pagination.service;

import com.pagination.modal.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    List<Product> findProductsWithSorting(String field);
    Page<Product> findProductsWithPagination(int offset, int pageSize);
    Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);
}
