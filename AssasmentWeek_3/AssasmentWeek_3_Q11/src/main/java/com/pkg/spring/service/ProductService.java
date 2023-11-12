// Product service interface
package com.pkg.spring.service;

import java.util.List;

import com.pkg.spring.model.Product;

public interface ProductService {

    void saveProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
