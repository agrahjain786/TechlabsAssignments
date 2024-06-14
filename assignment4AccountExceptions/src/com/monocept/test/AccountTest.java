package com.monocept.test;

import java.util.Scanner;

import com.monocept.exceptions.InsufficientFundsException;
import com.monocept.exceptions.NegativeAmountException;
import com.monocept.model.Account;

public class AccountTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		try {
			Account account1 = new Account("Agrah", 2345, 100000);
			System.out.println("Enter the amount to deposit: ");
			double amount = scanner.nextDouble();
			account1.deposit(amount);
			System.out.println("Enter the amount to withdraw: ");
			double amountWithdraw = scanner.nextDouble();
			account1.withdraw(amountWithdraw);
		}
		catch(InsufficientFundsException e) {
			e.printStackTrace();
		}
		catch(NegativeAmountException e) {
			e.printStackTrace();
		}
		
	}

}