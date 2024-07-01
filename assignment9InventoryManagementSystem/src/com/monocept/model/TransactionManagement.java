package com.monocept.model;

import com.monocept.exceptions.InsufficientStockException;
import com.monocept.exceptions.ProductNotFoundException;

public interface TransactionManagement {
	
	void addStock(String productId, int quantity) throws ProductNotFoundException;
	void removeStock(String productId, int quantity) throws ProductNotFoundException, InsufficientStockException;
	void getTransactionHistory(String productId);
	

}
