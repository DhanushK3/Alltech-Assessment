package com.problem;

import java.util.List;


public interface ProductDAO {
	
	
	public void createProduct(Product product);
	
	public Product readProduct(int id);
	
	public List<Product> readAllProducts();
	
	public void updateProduct(int id, Product product);
	
	public void deleteProduct(int id);

	


}
