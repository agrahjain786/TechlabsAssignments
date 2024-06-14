package com.monocept.exceptions;

public class InsufficientFundsException extends Exception{
	
	public String message() {
		return "Your account has insufficient balance";
	}

}
