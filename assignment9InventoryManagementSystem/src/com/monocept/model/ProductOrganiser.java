package com.monocept.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.monocept.exceptions.DuplicateProductException;
import com.monocept.exceptions.ProductNotFoundException;

public class ProductOrganiser implements ProductManagement{
	
	private Map<String, Product> products = new HashMap<>();;
	
	
	
	@Override
	public void addProduct(Product product) throws DuplicateProductException{
		
		if (products.containsKey(product.getProductId())) {
            throw new DuplicateProductException("Product with ID " + product.getProductId() + " already exists.");
        }
		products.put(product.getProductId(), product);
	}

	@Override
	public void updateProduct(Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		if (!products.containsKey(product.getProductId())) {
			throw new ProductNotFoundException("Product with ID " + product.getProductId() + " not found.");
		}
		products.put(product.getProductId(), product);
	}

	

	@Override
	public void deleteProduct(String productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		if (!products.containsKey(productId)) {
			throw new ProductNotFoundException("Product with ID " + productId + " not found.");
		}
		products.remove(productId);
		
	}

	@Override
	public Product getProduct(String productId) throws ProductNotFoundException {
		if (!products.containsKey(productId)) {
			throw new ProductNotFoundException("Product with ID " + productId + " not found.");
		}
			
		return products.get(productId);
	}

	@Override
	public void getAllProducts() {
		// TODO Auto-generated method stub
		for(Product product: products.values()) {
			System.out.println(product);
		}
		
	}
	
	
	public List<Product> getListOfAllProducts(){
		return new ArrayList<>(products.values());
	}
	
	
	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
	
	
}
