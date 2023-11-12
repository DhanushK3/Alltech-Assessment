package com.pkg.spring.dao;

import java.util.List;

import com.pkg.spring.model.Product;

public interface ProductDAO {
    void saveProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
