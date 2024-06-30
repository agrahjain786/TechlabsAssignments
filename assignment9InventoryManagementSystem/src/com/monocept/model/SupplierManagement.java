package com.monocept.model;


public interface SupplierManagement {
	
	void addSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(String supplierId);
    Supplier getSupplier(String supplierId);
    void getAllSuppliers();

}
