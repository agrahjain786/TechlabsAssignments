package com.monocept.model;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;


public class LoadData {
	
	private static final String PRODUCTS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/ProductInformation.txt";
    private static final String SUPPLIERS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/SupplierInformation.txt";
    private static final String TRANSACTIONS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/TransactionInformation.txt";
    
	
	public void loadProducts(ProductOrganiser productOrganiser) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(PRODUCTS_FILE);
			ObjectInputStream productFile = new ObjectInputStream(fileInputStream);
			
			Map<String, Product> products = productOrganiser.getProducts();
			
			Product product;
			while ((product = (Product) productFile.readObject()) != null) {
				if (!products.containsKey(product.getProductId())) {
					products.put(product.getProductId(), product);
		        }
		    }
			
			productOrganiser.setProducts(products);
        } 
		catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public void loadSuppliers(SupplierOrganiser supplierOrganiser) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(SUPPLIERS_FILE);
			ObjectInputStream supplierFile = new ObjectInputStream(fileInputStream);
			
			Map<String, Supplier> suppliers = supplierOrganiser.getSuppliers();
			
			Supplier supplier;
			while ((supplier = (Supplier) supplierFile.readObject()) != null) {
				if (!suppliers.containsKey(supplier.getSupplierId())) {
					suppliers.put(supplier.getSupplierId(), supplier);
		        }
		    }
			
			supplierOrganiser.setSuppliers(suppliers);
        } 
		catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public void loadTransactions (TransactionOrganiser transactionOrganiser) {
	
		try {
			FileInputStream fileInputStream = new FileInputStream(TRANSACTIONS_FILE);
			ObjectInputStream transactionFile = new ObjectInputStream(fileInputStream);
			
			List<Transaction> transactions = transactionOrganiser.getListOfAllTransactions();
			
			Transaction transaction;
			while ((transaction = (Transaction) transactionFile.readObject()) != null) {
				transactions.add(transaction);
		    }
			
			transactionOrganiser.setTransactions(transactions);
	    } 
		catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
}
