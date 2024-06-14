package com.monocept.model;

import com.monocept.exceptions.InsufficientFundsException;
import com.monocept.exceptions.NegativeAmountException;

public class Account {
	
	private String name;
	private int accountNumber;
	private double balance;
	
	public Account(String name, int accountNumber, double balance) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) throws NegativeAmountException {
		if(amount < 0)
			throw new NegativeAmountException();
		setBalance(getBalance()+amount); 
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if(amount > getBalance())
			throw new InsufficientFundsException();
		setBalance(getBalance()-amount);
	}

}