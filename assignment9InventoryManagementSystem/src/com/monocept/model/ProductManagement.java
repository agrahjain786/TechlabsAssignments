package com.monocept.model;

import com.monocept.exceptions.DuplicateProductException;
import com.monocept.exceptions.ProductNotFoundException;

public interface ProductManagement {
	
	void addProduct(Product product) throws DuplicateProductException;
    void updateProduct(Product product) throws ProductNotFoundException;
    void deleteProduct(String productId) throws ProductNotFoundException;
    Product getProduct(String productId) throws ProductNotFoundException;
    void getAllProducts();

}