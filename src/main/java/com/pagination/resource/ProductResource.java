package com.pagination.resource;

import com.pagination.dto.APIResponse;
import com.pagination.modal.Product;
import com.pagination.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private APIResponse<List<Product>> getProducts(){
        List<Product> products = productService.findAllProducts();
        return new APIResponse<>(products.size(), products);
    }
}
