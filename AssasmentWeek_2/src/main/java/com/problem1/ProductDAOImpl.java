package com.problem1;

import java.util.ArrayList;
import java.util.List;

import com.problem.Product;
import com.problem.ProductDAO;

public class ProductDAOImpl implements ProductDAO {
	
	List<Product> products = new ArrayList<>();

	@Override
	public void createProduct(Product product) {
	    products.add(product);
	}


	@Override
	public Product readProduct(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> readAllProducts() {
	
		return products;
	}

	@Override
	public void updateProduct(int id, Product updatedProduct) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId() == id) {
				products.set(i,updatedProduct);
				return;
			}
		}
		
	}

	 @Override
	    public void deleteProduct(int id) {
	        for (int i = 0; i < products.size(); i++) {
	            Product product = products.get(i);
	            if (product.getId() == id) {
	                products.remove(i);
	                break;
	            }
	        }
	    }




	

}
