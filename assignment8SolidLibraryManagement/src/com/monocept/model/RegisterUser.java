package com.monocept.model;

public class RegisterUser {
	
	User user;
	
	public RegisterUser(User user) {
		super();
		this.user = user;
	}
	

	public void userRegistration() {
		
		System.out.println("Registering user: " + user.getName() + " with ID: " + user.getUserId());
	}

}
