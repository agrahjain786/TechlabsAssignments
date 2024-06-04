package com.techlabs.accountModel;

public class SavingAccount extends Account{
	
	private double minBalance;

	public SavingAccount(int accountNumber, String name, double balance, double minBalance) {
		super(accountNumber, name, balance);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public void debit(double amount) {
		if(minBalance <= getBalance() - amount) {
			setBalance(getBalance() -amount);
			System.out.println("Debited "+amount+" from "+ getAccountNumber()+ " Hence Total Balance is "+ getBalance());
		}
		else System.out.println("Insufficient Amount to withdraw");
	}

}
