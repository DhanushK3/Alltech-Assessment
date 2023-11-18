package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.spring.entity.Employee;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@Validated @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }

    @PutMapping("/products")
    public Product edit(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/products")
    public String delete(@RequestParam(value = "id") Long id) {
        Optional<Product> optionalProduct = productService.get(id);

        if (optionalProduct.isPresent()) {
            productService.delete(optionalProduct.get());
            return "Product id: " + id + " deleted successfully";
        } else {
            return "Product with id: " + id + " not found";
        }
    }
}
