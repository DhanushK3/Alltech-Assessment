package com.problem3a;


import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.List;

public class ProductDAOHibernate implements ProductDAOInterface {

    @Override
    public void createProduct(Product product) {
    	Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();

        try {
            txn.begin();
            session.persist(product);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Product readProduct(int id) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> readAllProducts() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();
        return products;
    }

    @Override
    public void updateProduct(int id, Product product) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.beginTransaction();

        try {
            Product existingProduct = session.get(Product.class, id);
            if (existingProduct != null) {
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                session.update(existingProduct);
            }
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.beginTransaction();

        try {
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {
            session.close();
        }
    }

	
}
