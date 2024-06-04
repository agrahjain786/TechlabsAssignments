package com.techlabs.accountModel;

public class CurrentAccount extends Account{
	
	private double overdraftLimit;

	public CurrentAccount(int accountNumber, String name, double balance, double overdraftLimit) {
		super(accountNumber, name, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	public void debit(double amount) {
		if(amount <= getBalance() + overdraftLimit) {
			setBalance(getBalance() -amount);
			System.out.println("Debited "+amount+" from "+ getAccountNumber()+ " Hence Total Balance is "+ getBalance());
		}
		else System.out.println("Insufficient Amount to withdraw");
	}
	
	
}
