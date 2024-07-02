package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Book;
import com.monocept.model.BorrowBook;
import com.monocept.model.CatalogBook;
import com.monocept.model.EBook;
import com.monocept.model.Library;
import com.monocept.model.PrintedBook;
import com.monocept.model.RegisterUser;
import com.monocept.model.ReturnBook;
import com.monocept.model.User;

public class LibraryManagementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library library = new Library();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\nLibrary Management System Menu:");
			System.out.println("1. Add Book");
	        System.out.println("2. Register User");
	        System.out.println("3. Catalog Book");
	        System.out.println("4. Borrow Book");
	        System.out.println("5. Return Book");
	        System.out.println("6. View All Users");
	        System.out.println("7. Exit");
	        
	        System.out.print("Enter your choice: ");
			
	        int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
	            case 1:
	            	addBook(library, scanner);
	                break;
	            case 2:
	            	registerUser(library, scanner);
	               
	                break;
	            case 3:
	            	library.catalogBook();
	                break;
	            case 4:
	            	borrowBook(library, scanner);
	                break;
	            case 5:
	            	returnBook(library, scanner);
	                break;
	            case 6:
	                library.viewAllUsers();
	                break;
	            case 7:
	            	return;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	        
		}		

	}

	private static void returnBook(Library library, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        library.returnBook(userId , title);
		
		
	}

	private static void borrowBook(Library library, Scanner scanner) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        library.borrowBook(userId , title);
		
	}

	private static void registerUser(Library library, Scanner scanner) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        
        User user = new User(name, userId);
        library.registerUser(user);
		
	}

	private static void addBook(Library library, Scanner scanner) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Is the book borrowed? (true/false): ");
        boolean isBorrowed = scanner.nextBoolean();
        scanner.nextLine();
        
        System.out.println("Select book type:");
        System.out.println("1. Printed Book");
        System.out.println("2. E-Book");
        System.out.print("Enter your choice (1 or 2): ");
        int bookTypeChoice = scanner.nextInt();
        scanner.nextLine();
        
        Book book = null;
        switch (bookTypeChoice) {
            case 1:
                book = new PrintedBook(title, author, isBorrowed);
                break;
            case 2:
                book = new EBook(title, author, isBorrowed);
                break;
            default:
            	System.out.println("Select valid Choice");
            	break;
        }
        
        library.addBook(book);
		
	}
	
}
