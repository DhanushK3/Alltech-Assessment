package com.pkg.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pkg.spring.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Session session = sessionFactory.getCurrentSession();
        return (Product) session.get(Product.class, productId);
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Product").list();
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, productId);
        if (product != null) {
            session.delete(product);
        }
    }
}
