package com.problem1;

import java.util.Scanner;
import com.problem.Product;
import com.problem.ProductDAO;

public class ProductManagementApp {

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAOImpl();
		 Scanner scanner = new Scanner(System.in);
		 
		 while (true) {
	            System.out.println("===================  Menu  =========================");
	          
	            System.out.println("1. Create Product");
	            System.out.println("2. Read Product");
	            System.out.println("3. Show All Products");
	            System.out.println("4. Update Product");
	            System.out.println("5. Delete Product");
	            System.out.println("6. Exit");
	            
	            System.out.print("Please enter your choice: ");
	         
	            

	            int choice = scanner.nextInt();
	            scanner.nextLine(); //Consume newline

	            switch (choice) {
	            
	            
	            case 1:
	                System.out.println("=====================================================");
	                System.out.print("Enter the number of products to be added: ");
	                
	                int numberOfProducts = scanner.nextInt();
	                
	                scanner.nextLine();  //Consume newline

	                
	                for (int i = 1; i <= numberOfProducts; i++) {
	                	
	                    System.out.println("Product " + i + ":");
	                    System.out.println("===================");
	                    System.out.print("Enter product ID: ");
	                    int productId = scanner.nextInt();
	                    
	                    scanner.nextLine();
	                    	
	                    System.out.print("Enter product name: ");
	                    String productName = scanner.nextLine();
	                    
	                    System.out.print("Enter product price: ");
	                    double productPrice = scanner.nextDouble();

	                    Product product = new Product(productId, productName, productPrice);
	                    productDAO.createProduct(product);
	                    
	                    System.out.println("*********** Product added successfully. ***********");
	                }
	                break;

	                    
	                case 2:
	                    System.out.print("Enter product ID to read: ");
	                    int readProductId = scanner.nextInt();
	                    Product readProduct = productDAO.readProduct(readProductId);
	                    if (readProduct != null) {
	                    	
	                        System.out.println("*********** Product found: " + readProduct +"************");
	                    } else {
	                        System.out.println("%%%%%%%%%%% Product not found. %%%%%%%%%%%% ");
	                    }
	                    break;
	                    
	                    
	                case 3:
	                    System.out.println("======== All Products ========");
	                    
	                    for (Product p : productDAO.readAllProducts()) {
	                    	
	                        System.out.println(p);
	                    }
	                    break;
	                    
	                    
	                case 4:
	                    System.out.print("Enter product ID to update: ");
	                    int updateProductId = scanner.nextInt();
	                    
	                    scanner.nextLine();
	                    System.out.print("Enter new product name: ");
	                    
	                    String newProductName = scanner.nextLine();
	                    System.out.print("Enter new product price: ");
	                    
	                    double newProductPrice = scanner.nextDouble();

	                    Product updatedProduct = new Product(updateProductId, newProductName, newProductPrice);
	                    
	                    productDAO.updateProduct(updateProductId, updatedProduct);
	                    
	                    System.out.println("*********** Product updated successfully. ***********");
	                    break;

	                    
	                    
	                case 5:
	                    System.out.print("Enter product ID to delete: ");
	                    int deleteProductId = scanner.nextInt();
	                    
	                    productDAO.deleteProduct(deleteProductId);
	                    
	                    System.out.println("*********** Product deleted successfully. ***********");
	                    break;

	                case 6:
	                    System.out.println("*********** Exit ***********");
	                    
	                    System.exit(0);
	                default:
	                	
	                    System.out.println("Invalid, Please enter a valid option.");
	            
	            }
	       }  
	}

}
