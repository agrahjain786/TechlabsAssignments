package com.monocept.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveData {
	
	private static final String PRODUCTS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/ProductInformation.txt";
    private static final String SUPPLIERS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/SupplierInformation.txt";
    private static final String TRANSACTIONS_FILE = "/Users/abhijain/TechlabsAssignments/assignment9InventoryManagementSystem/src/com/monocept/model/TransactionInformation.txt";
    
    public void saveProducts(ProductOrganiser productOrganiser) {
    	
    	List<Product> products = new ArrayList<>(productOrganiser.getListOfAllProducts());
    	
        try (ObjectOutputStream productFile = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE))) {
        	for (Product product : products) {
        		productFile.writeObject(product);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSuppliers(SupplierOrganiser supplierOrganiser) {
    	
    	List<Supplier> suppliers = new ArrayList<>(supplierOrganiser.getListOfAllSuppliers());
    	
        try (ObjectOutputStream supplierFile = new ObjectOutputStream(new FileOutputStream(SUPPLIERS_FILE))) {
        	for (Supplier supplier : suppliers) {
        		supplierFile.writeObject(supplier);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveTransactions(TransactionOrganiser transactionOrganiser) {
    	
    	List<Transaction> transactions = new ArrayList<>(transactionOrganiser.getListOfAllTransactions());
    	
        try (ObjectOutputStream transactionFile = new ObjectOutputStream(new FileOutputStream(TRANSACTIONS_FILE))) {
        	for (Transaction transaction : transactions) {
        		transactionFile.writeObject(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
