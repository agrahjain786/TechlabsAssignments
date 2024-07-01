package com.monocept.model;

import com.monocept.exceptions.DuplicateSupplierException;
import com.monocept.exceptions.SupplierNotFoundException;

public interface SupplierManagement {
	
	void addSupplier(Supplier supplier) throws DuplicateSupplierException;
    void updateSupplier(Supplier supplier) throws SupplierNotFoundException;
    void deleteSupplier(String supplierId) throws SupplierNotFoundException;
    Supplier getSupplier(String supplierId) throws SupplierNotFoundException;
    void getAllSuppliers();

}
