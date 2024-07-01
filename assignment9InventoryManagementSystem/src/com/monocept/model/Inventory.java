package com.monocept.model;

import java.util.Scanner;

import com.monocept.exceptions.DuplicateProductException;
import com.monocept.exceptions.DuplicateSupplierException;
import com.monocept.exceptions.InsufficientStockException;
import com.monocept.exceptions.ProductNotFoundException;
import com.monocept.exceptions.SupplierNotFoundException;

public class Inventory {
	
    private ProductOrganiser productOrganiser;
    private SupplierOrganiser supplierOrganiser;
    private TransactionOrganiser transactionOrganiser;
    private SaveData saveData;
    private LoadData loadData;
    private StockSummary reports;
    
    Scanner scanner = new Scanner(System.in);
    
	public Inventory() {
	this.productOrganiser = new ProductOrganiser();
        this.supplierOrganiser = new SupplierOrganiser();
        this.transactionOrganiser = new TransactionOrganiser((ProductOrganiser) productOrganiser);
        this.saveData = new SaveData();
        this.loadData = new LoadData();
        reports = new StockSummary((ProductOrganiser) productOrganiser, (SupplierOrganiser) supplierOrganiser);
	}
	
	public void addProduct() {
		try {
		    System.out.println("Enter the details of Product:");
			
		    System.out.print("Enter product name: ");
		    String productName = scanner.nextLine();
		    
		    System.out.print("Enter product Desciption: ");
		    String productDescription = scanner.nextLine();
		    
		    System.out.print("Enter product quantity: ");
		    int quantity = Integer.parseInt(scanner.nextLine());
		    
		    System.out.print("Enter product price: ");
		    double price = Double.parseDouble(scanner.nextLine());
		
		    Product product = new Product(productName, productDescription, quantity, price);
		    
                    productOrganiser.addProduct(product);
                    System.out.println("Product added successfully.");
               } 
               catch (DuplicateProductException e) {
                    System.out.println("Error: " + e.getMessage());
                }
        }
	
	public void updateProduct() {
		try {
		    System.out.println("Enter the new details of Product:");
			
		    System.out.print("Enter product ID: ");
            	    String productId = scanner.nextLine();

		    System.out.print("Enter product name: ");
		    String productName = scanner.nextLine();
		    
		    System.out.print("Enter product Desciption: ");
		    String productDescription = scanner.nextLine();
		    
		    System.out.print("Enter product quantity: ");
		    int quantity = Integer.parseInt(scanner.nextLine());
		    
		    System.out.print("Enter product price: ");
		    double price = Double.parseDouble(scanner.nextLine());
		
		    Product product = new Product(productId, productName, productDescription, quantity, price);
		    
                    productOrganiser.updateProduct(product);
                    System.out.println("Product details updated successfully.");
                } 
                catch (ProductNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                 }
	}
	
	public void deleteProduct() {
		try {
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
            
                    productOrganiser.deleteProduct(productId);
                    System.out.println("Product deleted successfully.");
                } 
		catch (ProductNotFoundException e) {
                    System.out.println("Error: "+ e.getMessage());
                 }
	}
	
	public void getProductDetails() {
		try {
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
            
                    Product product = productOrganiser.getProduct(productId);
                    System.out.println("Product Details: " + product);
                } 
		catch (ProductNotFoundException e) {
                    System.out.println("Error: "+ e.getMessage());
                 }
	}
	
	public void getAllProductDetails() {
		productOrganiser.getAllProducts();
	}
	
	public void addSupplier() {
		try {
		    System.out.println("Enter the details of Supplier:");
			
		    System.out.print("Enter Supplier name: ");
		    String supplierName = scanner.nextLine();
		    
		    System.out.print("Enter Supplier Contact Information: ");
		    String supplierContactInfo = scanner.nextLine();
		
		    Supplier supplier = new Supplier(supplierName, supplierContactInfo);
		    
                    supplierOrganiser.addSupplier(supplier);
                    System.out.println("Supplier added successfully.");
                } 
                catch (DuplicateSupplierException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
         }
	
	public void updateSupplier() {
		try {
		    System.out.println("Enter the new details of Supplier:");
			
		    System.out.print("Enter Supplier ID: ");
                    String supplierId = scanner.nextLine();
			
		    System.out.print("Enter Supplier name: ");
		    String supplierName = scanner.nextLine();
		    
		    System.out.print("Enter Supplier Contact Information: ");
		    String supplierContactInfo = scanner.nextLine();
		
		    Supplier supplier = new Supplier(supplierId, supplierName, supplierContactInfo);
		    
                    supplierOrganiser.updateSupplier(supplier);
                    System.out.println("Supplier details updated successfully.");
                } 
                catch (SupplierNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
	}
	
	public void deleteSupplier() {
		try {
		    System.out.print("Enter Supplier ID: ");
                    String supplierId = scanner.nextLine();
            
                    supplierOrganiser.deleteSupplier(supplierId);
                    System.out.println("Supplier deleted successfully.");
                } 
		catch (SupplierNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
	}
	
	public void getSupplierDetails() {
		try {
		    System.out.print("Enter Supplier ID: ");
                    String supplierId = scanner.nextLine();
            
                    Supplier supplier = supplierOrganiser.getSupplier(supplierId);
                    System.out.println("Product Details: " + supplier);
                } 
		catch (SupplierNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
	}
	
	public void getAllSuppliersDetails() {
		supplierOrganiser.getAllSuppliers();
	}
	
	public void addStock() {
		try {
		    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
            
                    System.out.print("Enter product quantity: ");
		    int quantity = Integer.parseInt(scanner.nextLine());
            
                    transactionOrganiser.addStock(productId, quantity);
                    System.out.println("Stock added Successfully.");
                } 
		catch (ProductNotFoundException e) {
                     System.out.println("Error: " + e.getMessage());
                }
	}
	
	public void removeStock(){
		try {
		    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
            
                    System.out.print("Enter product quantity: ");
		    int quantity = Integer.parseInt(scanner.nextLine());
            
                    transactionOrganiser.removeStock(productId, quantity);
                    System.out.println("Stock removed Successfully.");
                } 
		catch (ProductNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
		catch (InsufficientStockException e) {
                    System.out.println("Error: " + e.getMessage());
                }
	}
	
	public void getTransactionHistory() {
		System.out.print("Enter product ID: ");
                String productId = scanner.nextLine();
		
		transactionOrganiser.getTransactionHistory(productId);
	}
	
	public void saveAllData() {
		
		saveData.saveProducts(productOrganiser);
		saveData.saveSuppliers(supplierOrganiser);
		saveData.saveTransactions(transactionOrganiser);
		
	}
	
	public void loadAllData() {
		
		loadData.loadProducts(productOrganiser);
		loadData.loadSuppliers(supplierOrganiser);
		loadData.loadTransactions(transactionOrganiser);
		
	}
	
	public void generateReports() {
		
		System.out.println("Total Number of products: "+ reports.getTotalNumberOfProducts());
		System.out.println("Total Stock presented: "+ reports.getTotalStockValue());
		System.out.println("Total Number of Suppliers: "+ reports.getTotalNumberOfSuppliers());
		
	}
	
	
}
