package com.problem3a;

import java.util.List;


public interface ProductDAOInterface {
	
	
	public void createProduct(Product product);
	
	public Product readProduct(int id);
	
	public List<Product> readAllProducts();
	
	public void updateProduct(int id, Product product);
	
	public void deleteProduct(int id);

	


}
