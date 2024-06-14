package com.techlabs.exceptions;

public class NoSuchMovieFoundException extends RuntimeException{
	
	public String getMessage() { 
		return "There is no such movie of that ID";
	}
}
