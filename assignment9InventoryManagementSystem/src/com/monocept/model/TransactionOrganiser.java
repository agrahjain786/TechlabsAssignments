package com.monocept.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.monocept.exceptions.InsufficientStockException;
import com.monocept.exceptions.ProductNotFoundException;

public class TransactionOrganiser implements TransactionManagement{
	
	private List<Transaction> transactions = new ArrayList<>();
    private ProductOrganiser productOrganiser;
    private ExecutorService executorService;

    public TransactionOrganiser(ProductOrganiser productOrganiser) {
        this.productOrganiser = productOrganiser;
    }

    @Override
    public void addStock(String productId, int quantity) throws ProductNotFoundException {
    	executorService.submit(() -> {
            try {
                Product product = productOrganiser.getProduct(productId);
                if (product == null) {
                    throw new ProductNotFoundException("Product with ID " + productId + " not found.");
                }
                synchronized (product) {
                    product.setQuantity(product.getQuantity() + quantity);
                    Transaction transaction = new Transaction(productId, "ADD", quantity, new Date());
                    transactions.add(transaction);
                }
            } catch (ProductNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void removeStock(String productId, int quantity) throws ProductNotFoundException, InsufficientStockException {
    	executorService.submit(() -> {
            try {
                Product product = productOrganiser.getProduct(productId);
                if (product == null) {
                    throw new ProductNotFoundException("Product with ID " + productId + " not found.");
                }
                synchronized (product) {
                    if (product.getQuantity() < quantity) {
                        throw new InsufficientStockException("Not enough stock available for product ID " + productId);
                    }
                    product.setQuantity(product.getQuantity() - quantity);
                    Transaction transaction = new Transaction(productId, "REMOVE", quantity, new Date());
                    transactions.add(transaction);
                }
            } catch (ProductNotFoundException | InsufficientStockException e) {
                e.printStackTrace(); 
            }
        });
    }

    @Override
    public void getTransactionHistory(String productId) {
        for (Transaction transaction : transactions) {
            if (transaction.getProductId().equals(productId)) {
                System.out.println(transaction);
            }
        }
    }
    
    public List<Transaction> getListOfAllTransactions(){
    	return transactions;
    }

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
    

}
