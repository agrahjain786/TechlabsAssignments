package com.monocept.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	private Map<String, Product> products;
    private Map<String, Supplier> suppliers;
    private List<Transaction> transactions;
    
    public Inventory() {
        products = new HashMap<>();
        suppliers = new HashMap<>();
        transactions = new ArrayList<>();
    }
    
    

}
