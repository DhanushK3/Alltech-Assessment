package com.problem2a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.problem.Product;
import com.problem.ProductDAO;


public class ProductDAOJDBC implements ProductDAO {
	
	private Connection connection;
	
	public ProductDAOJDBC() {
		
		try {
			
			// Establish JDBC connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagemantjdbc", "root", "root");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}

	@Override
	public void createProduct(Product product) {
		
		 String query = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";
		 
		 try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 
			 	preparedStatement.setInt(1, product.getId());
			 	
	            preparedStatement.setString(2, product.getName());
	            
	            preparedStatement.setDouble(3, product.getPrice());
	            
	            preparedStatement.executeUpdate();
	            
		 }catch(Exception e) {
			 
			 e.printStackTrace();
		 }
	}
	
	

	@Override
	public Product readProduct(int id) {
		
		String query = "SELECT id, name, price FROM products WHERE id = ?";
		
		 try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 	
			 preparedStatement.setInt(1, id);
			 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 
	            if (resultSet.next()) {
	            	
	                int productId = resultSet.getInt("id");
	                String productName = resultSet.getString("name");               
	                double productPrice = resultSet.getDouble("price");
	                
	                return new Product(productId, productName, productPrice);
	            }
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	        return null;
	}
	
	@Override
	 public List<Product> readAllProducts() {
		 
		 List<Product> products = new ArrayList<>();
		 String query = "SELECT id, name, price FROM products";
		 
		 try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 
		 
		 ResultSet resultSet = preparedStatement.executeQuery();
		 
	            while (resultSet.next()) {
	            	
	                int productId = resultSet.getInt("id");
	                String productName = resultSet.getString("name");
	                double productPrice = resultSet.getDouble("price");
	                
	                products.add(new Product(productId, productName, productPrice));
	            }
		 }catch (Exception e) {
			 
			 e.printStackTrace();
		 }
		 
		return products;
	 }
	 
		@Override
	    public void updateProduct(int id, Product product) {
	    	
	    	
	        String query = "UPDATE products SET name = ?, price = ? WHERE id = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	            preparedStatement.setString(1, product.getName());
	            preparedStatement.setDouble(2, product.getPrice());
	            preparedStatement.setInt(3, id);
	            
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        }
	    }
		
		@Override
	    public void deleteProduct(int id) {
	    	
	        String sql = "DELETE FROM products WHERE id = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        }
	    }
	
	    
	    public void close() {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }




		

	
}


