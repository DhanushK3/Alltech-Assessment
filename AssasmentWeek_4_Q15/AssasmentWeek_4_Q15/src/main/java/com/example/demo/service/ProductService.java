package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> fetchProductList();

    Product update(Product product);

    void delete(Product product);

    Optional<Product> get(Long productId);
}
