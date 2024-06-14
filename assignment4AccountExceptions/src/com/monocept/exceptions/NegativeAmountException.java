package com.monocept.exceptions;

public class NegativeAmountException extends Exception{
	
	public String message() {
		return "Negative amount in account";
	}

}