package com.pkg.tax;

import java.util.Scanner;

public class Order {

	private int orderId;
    private String orderName;
    private String category;
    private double price;
    private double tax;
    
    public void acceptData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        
        orderId = scanner.nextInt();

        scanner.nextLine(); //consum line

        
        System.out.print("Enter Order Name: ");
        
        orderName = scanner.nextLine();

        System.out.print("Enter Price: ");
        
        price = scanner.nextDouble();

        System.out.print("Enter Category (Shipping, Air, Road): ");
        
        category = scanner.next();
    
    }
    
    public void calTax() {
    	
        switch (category.toLowerCase()) {
        
            case "shipping":
                tax = price * 0.15;
                break;
                
            case "air":
                tax = price * 0.25;
                break;
                
            case "road":
                tax = price * 0.08;
                break;
                
            default:
                System.out.println("Tax calculation error.");
                break;
        }
    }
    
    public void dispOrder() {
    	
        double totalPrice = price + tax;
        
        System.out.println("======================================");

        System.out.println("Order Details:");
        
        System.out.println("OrderID: " + orderId);
        
        System.out.println("OrderName: " + orderName);
        
        System.out.println("Total Price: " + totalPrice);
        
    }
}
