package com.monocept.model;

public class UniqueIDGenerator {
	
	private static int productCounter = 0;
    private static int supplierCounter = 0;
    private static int transactionCounter = 0;
    
    public static synchronized String generateProductId() {
        return "PROD-" + productCounter++;
    }

    public static synchronized String generateSupplierId() {
        return "SUP-" + supplierCounter++;
    }

	public static String generateTransactionId() {
		// TODO Auto-generated method stub
		return "TXN-" + transactionCounter++;
	}

}
