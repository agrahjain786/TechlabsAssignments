package com.techlabs.exceptions;

public class CapacityFullException extends RuntimeException{
	
	public String getMessage() { 
		return "Capacity is full. Cant add movie";
	}
}
