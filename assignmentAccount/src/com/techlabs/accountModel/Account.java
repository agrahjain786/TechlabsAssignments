package com.techlabs.accountModel;

public class Account {
	
	private int accountNumber;
	private String name;
	private double balance;
	
	
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public void credit(double amount) {
		balance += amount;
		System.out.println("Credited "+ amount+ " in " + accountNumber+ " Hence Total Balance is "+ balance);
	}
	
	public void debit(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Debited "+amount+" from "+ accountNumber+ " Hence Total Balance is "+ balance);
		}
		else System.out.println("Insufficient Balance");
	}
	
	public void display() {
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Name: "+name);
		System.out.println("Total Balance: "+balance);
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
