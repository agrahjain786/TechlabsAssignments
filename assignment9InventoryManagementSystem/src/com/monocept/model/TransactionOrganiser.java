package com.monocept.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.monocept.exceptions.InsufficientStockException;
import com.monocept.exceptions.ProductNotFoundException;

public class TransactionOrganiser implements TransactionManagement{
	
	private List<Transaction> transactions;
    private ProductOrganiser productOrganiser;

    public TransactionOrganiser(ProductOrganiser productOrganiser) {
        this.transactions = new ArrayList<>();
        this.productOrganiser = productOrganiser;
    }

    @Override
    public void addStock(String productId, int quantity) throws ProductNotFoundException {
        Product product = productOrganiser.getProduct(productId);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
        product.setQuantity(product.getQuantity() + quantity);
        Transaction transaction = new Transaction(productId,"ADD",quantity, new Date());
        transactions.add(transaction);
    }

    @Override
    public void removeStock(String productId, int quantity) 
            throws ProductNotFoundException, InsufficientStockException {
        Product product = productOrganiser.getProduct(productId);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
        if (product.getQuantity() < quantity) {
            throw new InsufficientStockException("Not enough stock available for product ID " + productId);
        }
        product.setQuantity(product.getQuantity() - quantity);
        Transaction transaction = new Transaction(productId,"REMOVE",quantity, new Date());
        transactions.add(transaction);
    }

    @Override
    public void getTransactionHistory(String productId) {
        for (Transaction transaction : transactions) {
            if (transaction.getProductId().equals(productId)) {
                System.out.println(transaction);
            }
        }
    }
	

}
