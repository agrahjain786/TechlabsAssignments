package com.monocept.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	List<Book> books;
	List<User> users;
	
	public Library() {
		this.books = new ArrayList<Book>();
		this.users = new ArrayList<User>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        
        return null;
    }
	
    public void addBook(Book book) {
    	Book bookToAdd = findBookByTitle(book.getTitle());
    	if(bookToAdd == null) {
    		books.add(book);
    		System.out.println("Book Added successfully");
    		return;
    	}
    	System.out.println("Book Already Added");
    }

	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
		User userToAdd = findUserById(user.getUserId());
		if(userToAdd == null) {
			users.add(user);
			RegisterUser registerUser = new RegisterUser(user);
			registerUser.userRegistration();
    		return;
		}
		System.out.println("User has Already Registered");
		
	}
	
	public void catalogBook() {
		for(Book book : books) {
			System.out.println(book);
		}
	}
    
	public void borrowBook(String userId, String title) {
		User user = findUserById(userId);
		if (user == null) {
            System.out.println("User not found.");
            return;
        }
		Book book = findBookByTitle(title);
		if (book == null) {
            System.out.println("Book not found.");
            return;
        }
		BorrowBook borrowBook = new BorrowBook(book, user);
        borrowBook.borrowBook();
        System.out.println("Book borrowed successfully");
	}
	
	public void returnBook(String userId, String title) {
		User user = findUserById(userId);
		if (user == null) {
            System.out.println("User not found.");
            return;
        }
		Book book = findBookByTitle(title);
		if (book == null) {
            System.out.println("Book not found.");
            return;
        }
		ReturnBook returnBook = new ReturnBook(book, user);
        returnBook.returnBook();
        System.out.println("Book returned successfully");
	}

	public void viewAllUsers() {
		// TODO Auto-generated method stub
		
		for(User user : users) {
			System.out.println(user);
		}
		
	}
	
	

}
