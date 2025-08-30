package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Product;
import com.excelr.response.APIResponse;
import com.excelr.service.ProductService;

// Use @RestController to automatically handle @ResponseBody
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // Assuming APIResponse is a wrapper that you have in your project
    @GetMapping
    public APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = service.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts); // Return wrapped response
    }

    @GetMapping("/pagination/{page}/{pageSize}")
    public APIResponse<Page<Product>> getProductWithPagination(@PathVariable int page, @PathVariable int pageSize) {
        Page<Product> productWithPagination = service.findProductsWithPagination(page, pageSize);
        return new APIResponse<>(productWithPagination.getSize(), productWithPagination);
    }
}
