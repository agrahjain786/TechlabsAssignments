package com.monocept.model;

import java.util.List;

public class StockSummary {
	
	private ProductOrganiser productOrganiser;
	private SupplierOrganiser supplierOrganiser;
	
	
	public StockSummary(ProductOrganiser productOrganiser, SupplierOrganiser supplierOrganiser) {
		super();
		this.productOrganiser = productOrganiser;
		this.supplierOrganiser = supplierOrganiser;
	}
	
	public int getTotalNumberOfProducts() {
        return productOrganiser.getProducts().size();
    }

	public double getTotalStockValue() {
		
		List<Product> products = productOrganiser.getListOfAllProducts();
				
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }
	
	public int getTotalNumberOfSuppliers() {
        return supplierOrganiser.getSuppliers().size();
    }
}
