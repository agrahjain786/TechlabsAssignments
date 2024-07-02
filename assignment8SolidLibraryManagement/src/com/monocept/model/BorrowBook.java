package com.monocept.model;

public class BorrowBook implements IBorrowBook{
	
	Book book;
	User user;

	public BorrowBook(Book book, User user) {
		super();
		this.book = book;
		this.user = user;
	}
	
	public void borrowBook() {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            book.setBorrowerId(user.getUserId());
            System.out.println(user.getName() + " has borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is already borrowed.");
        }
    }

}
