package com.techlabs.accountTest;

import com.techlabs.accountModel.*;
import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Account account = null;
		
		System.out.println("Select Account Type :");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.println("3. Exit");
        System.out.print("Enter Your Choice: ");
        
        int accountTypeChoice = scanner.nextInt();
        	
        while(accountTypeChoice != 3) {
    		
    		System.out.println("Select Operation :");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Credit into Account");
            System.out.println("4. Debit from Account");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            
            int operationChoice = scanner.nextInt();
            
            if(operationChoice == 5) break;
            
            switch (operationChoice) {
            	case 1:
            		account = createAccount(account, accountTypeChoice, scanner);
            		System.out.println("Your account is created.");
            		break;
            	case 2:
            		displayAccount(account);
            		break;
            	case 3:
            		creditAccount(account, scanner);
            		break;
            	case 4:
            		debitAccount(account, scanner);
            		break;
            	default:
            		System.out.println("Enter a Valid Choice.");
                    
            }
    	}
        
        scanner.close();
        return;
	}

	public static Account createAccount(Account account, int accountTypeChoice, Scanner scanner) {
		
		System.out.println("You selected creating new account");
		
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.next();
        System.out.print("Enter Opening Balance: ");
        double balance = scanner.nextDouble();
        
        if(accountTypeChoice == 1) {
        	System.out.print("Enter Minimum Balance: ");
            double minBalance = scanner.nextDouble();
            return new SavingAccount(accountNumber, name, balance, minBalance);
        }
        
        System.out.print("Enter Overdraft Limit: ");
        double overdraftLimit = scanner.nextDouble();
        return new CurrentAccount(accountNumber, name, balance, overdraftLimit);
        
	}
	
	public static void displayAccount(Account account) {
		if(account == null) {
			System.out.println("Create an account.");
			return;
		}
		account.display();
		
	}
	
	private static void creditAccount(Account account, Scanner scanner) {
		if(account == null) {
			System.out.println("Create an account.");
			return;
		}
		System.out.print("Enter Amount to credit: ");
        double creditAmount = scanner.nextDouble();
        account.credit(creditAmount);
		
	}
	
	private static void debitAccount(Account account, Scanner scanner) {
		if(account == null) {
			System.out.println("Create an account.");
			return;
		}
		System.out.print("Enter Amount to debit: ");
        double debitAmount = scanner.nextDouble();
		account.debit(debitAmount);
		
	}

}
