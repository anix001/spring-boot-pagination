package com.pagination.resource;

import com.pagination.dto.APIResponse;
import com.pagination.modal.Product;
import com.pagination.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field){
        List<Product> products = productService.findProductsWithSorting(field);
        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Product> products = productService.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(products.getSize(), products);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field){
       Page<Product> products = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
       return new APIResponse<>(products.getSize(), products);
    }
}
