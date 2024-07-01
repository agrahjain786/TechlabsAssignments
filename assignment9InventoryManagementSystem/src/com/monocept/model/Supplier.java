package com.monocept.model;

public class Supplier {
	
	private String supplierId;
    private String name;
    private String contactInformation;
    
    
	public Supplier(String supplierId, String name, String contactInformation) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.contactInformation = contactInformation;
	}


	public String getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactInformation() {
		return contactInformation;
	}


	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}


	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name + ", contactInformation=" + contactInformation
				+ "]";
	}
    
    

}
