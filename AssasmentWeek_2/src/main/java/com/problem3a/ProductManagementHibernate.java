package com.problem3a;

import java.util.List;
import java.util.Scanner;

public class ProductManagementHibernate {

    public static void main(String[] args) {
        ProductDAOHibernate productDAO = new ProductDAOHibernate();
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
                    
                    scanner.nextLine(); //Consume newline

                    for (int i = 1; i <= numberOfProducts; i++) {
                        System.out.println("Product " + i + ":");
                        System.out.println("=============================");
                        
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                                     
                        
                        System.out.print("Enter product price: ");
                        double productPrice = scanner.nextDouble();

                        scanner.nextLine(); //Consume newline
                        
                        Product product = new Product(productName, productPrice);
                        
                        productDAO.createProduct(product);
                        
                        System.out.println("*********** Product added successfully. ***********");
                    }
                    
                    break;

                case 2:
                    System.out.print("Enter product ID to read: ");
                    
                    int readProductId = scanner.nextInt();
                    
                    Product readProduct = productDAO.readProduct(readProductId);
                    

                    if (readProduct != null) {
                    	
                        System.out.println("*********** Product found: " + readProduct + " ************");
                        
                    } else {
                    	
                        System.out.println("%%%%%%%%%%% Product not found. %%%%%%%%%%%% ");
                    }
                    
                    break;
                    

                case 3:
                    System.out.println("========== Show All Products ==========");
                    
                    List<Product> allProducts = productDAO.readAllProducts();

                    if (!allProducts.isEmpty()) {
                    	
                        for (Product p : allProducts) {
                        	
                            System.out.println(p);
                        }
                    } else {
                    	
                        System.out.println("No products found.");
                    }
                    break;

                case 4:
                    System.out.println("========== Update Product ==========");
                    System.out.print("Enter product ID to update: ");
                    
                    int updateProductId = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter new product name: ");
                    
                    String newProductName = scanner.nextLine();
                    System.out.print("Enter new product price: ");
                    
                    double newProductPrice = scanner.nextDouble();

                    Product updatedProduct = new Product(newProductName, newProductPrice);
                    
                    productDAO.updateProduct(updateProductId, updatedProduct);
                    
                    System.out.println("*********** Product updated successfully. ***********");
                    break;
                    

                case 5:
                    System.out.println("========== Delete Product ==========");
                    System.out.print("Enter product ID to delete: ");
                    
                    int deleteProductId = scanner.nextInt();
                    
                    
                    productDAO.deleteProduct(deleteProductId);
                    
                    System.out.println("*********** Product deleted successfully. ***********");
                    
                    break;

                case 6:
                    System.out.println("********************** Exit **********************");
                    
                    System.exit(0);

                default:
                    System.out.println("Invalid, please enter a valid option.");
            }
        }
    }
}

