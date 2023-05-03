package com.pagination.service.impl;

import com.pagination.modal.Product;
import com.pagination.repository.ProductRepository;
import com.pagination.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.fetchAllProducts();
    }

    @Override
    public List<Product> findProductsWithSorting(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
//        return productRepository.fetchAllProductsWithSorting(field);
    }

    @Override
    public Page<Product> findProductsWithPagination(int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
        return productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }

//  to add random 200 data
//    @PostConstruct
//    public void initDB(){
//        List<Product> products = IntStream.rangeClosed(1,200)
//                .mapToObj(i->new Product("product" + i, Math.abs(new Random().nextLong()), Math.abs(new Random().nextLong())))
//                .collect(Collectors.toList());
//
//        productRepository.saveAll(products);
//    }

}
