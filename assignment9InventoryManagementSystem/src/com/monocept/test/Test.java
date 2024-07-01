package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Inventory;

public class Test {
	
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	Scanner scanner = new Scanner(System.in);
		
	Inventory inventory = new Inventory();
		
	while (true) {
            System.out.println("Welcome to the Inventory Management System");
            System.out.println("1. Product Management");
            System.out.println("2. Supplier Management");
            System.out.println("3. Transaction Management");
            System.out.println("4. Save Data");
            System.out.println("5. Load Data");
            System.out.println("6. Generate Reports");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
	            case 1:
	                handleProductManagement(inventory, scanner);
	                break;
	            case 2:
	                handleSupplierManagement(inventory, scanner);
	                break;
	            case 3:
	                handleTransactionManagement(inventory, scanner);
	                break;
	            case 4:
	                inventory.saveAllData();
	                System.out.println("Data saved successfully.");
	                break;
	            case 5:
	                inventory.loadAllData();
	                System.out.println("Data loaded successfully.");
	                break;
	            case 6:
	                inventory.generateReports();
	                break;
	            case 7:
	                System.out.println("Exiting Inventory Management System. Goodbye!");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	        }
	}
		
}

private static void handleProductManagement(Inventory inventory, Scanner scanner) {
		// TODO Auto-generated method stub
	System.out.println("\nProduct Management:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. View Product Details");
        System.out.println("5. View All Products");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
	        case 1:
	            inventory.addProduct();
	            break;
	        case 2:
	            inventory.updateProduct();
	            break;
	        case 3:
	            inventory.deleteProduct();
	            break;
	        case 4:
	            inventory.getProductDetails();
	            break;
	        case 5:
	            inventory.getAllProductDetails();
	            break;
	        default:
	            System.out.println("Invalid choice.");
	    }
		
	}
	
	
private static void handleSupplierManagement(Inventory inventory, Scanner scanner) {
	// TODO Auto-generated method stub
		
	System.out.println("Supplier Management:");
        System.out.println("1. Add Supplier");
        System.out.println("2. Update Supplier");
        System.out.println("3. Delete Supplier");
        System.out.println("4. View Supplier Details");
        System.out.println("5. View All Suppliers");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
	        case 1:
	        	inventory.addSupplier();
	            break;
	        case 2:
	        	inventory.updateSupplier();
	            break;
	        case 3:
	        	inventory.deleteSupplier();
	            break;
	        case 4:
	        	inventory.getSupplierDetails();
	            break;
	        case 5:
	        	inventory.getAllSuppliersDetails();
	            break;
	        default:
	            System.out.println("Invalid choice");
	     }
		
	}
	
	
private static void handleTransactionManagement(Inventory inventory, Scanner scanner) {
	// TODO Auto-generated method stub
	System.out.println("Transaction Management: ");
        System.out.println("1. Add Stock");
        System.out.println("2. Remove Stock");
        System.out.println("3. View Transaction History");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
		
        switch (choice) {
	        case 1:
	            inventory.addStock();
	            break;
	        case 2:
	            inventory.removeStock();
	            break;
	        case 3:
	            inventory.getTransactionHistory();
	            break;
	        default:
	            System.out.println("Invalid choice");
        }
		
}

}
