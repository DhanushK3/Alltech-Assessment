package com.pkg.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pkg.spring.dao.ProductDAO;
import com.pkg.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Override
    @Transactional
    public Product getProductById(Long productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        productDAO.deleteProduct(productId);
    }
}
