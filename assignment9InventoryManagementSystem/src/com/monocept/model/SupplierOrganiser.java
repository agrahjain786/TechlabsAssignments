package com.monocept.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.monocept.exceptions.DuplicateSupplierException;
import com.monocept.exceptions.SupplierNotFoundException;

public class SupplierOrganiser implements SupplierManagement{
	
	private Map<String, Supplier> suppliers = new HashMap<>();;
	
	

	public void addSupplier(Supplier supplier) throws DuplicateSupplierException {
        if (suppliers.containsKey(supplier.getSupplierId())) {
            throw new DuplicateSupplierException("Supplier with ID " + supplier.getSupplierId() + " already exists.");
        }
        suppliers.put(supplier.getSupplierId(), supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SupplierNotFoundException {
        if (!suppliers.containsKey(supplier.getSupplierId())) {
            throw new SupplierNotFoundException("Supplier with ID " + supplier.getSupplierId() + " not found.");
        }
        suppliers.put(supplier.getSupplierId(), supplier);
    }

    @Override
    public void deleteSupplier(String supplierId) throws SupplierNotFoundException {
        if (!suppliers.containsKey(supplierId)) {
            throw new SupplierNotFoundException("Supplier with ID " + supplierId + " not found.");
        }
        suppliers.remove(supplierId);
    }

    @Override
    public Supplier getSupplier(String supplierId) throws SupplierNotFoundException {
        Supplier supplier = suppliers.get(supplierId);
        if (supplier == null) {
            throw new SupplierNotFoundException("Supplier with ID " + supplierId + " not found.");
        }
        return supplier;
    }

	@Override
	public void getAllSuppliers() {
		// TODO Auto-generated method stub
		for(Supplier supplier: suppliers.values()) {
			System.out.println(supplier);
		}
	}
	
	public List<Supplier> getListOfAllSuppliers(){
		return new ArrayList<>(suppliers.values());
	}

	public Map<String, Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Map<String, Supplier> suppliers) {
		this.suppliers = suppliers;
	}

}
