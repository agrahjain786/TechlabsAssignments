package com.monocept.model;

public class ReturnBook implements IReturnBook{
	
	Book book;
	User user;

	public ReturnBook(Book book, User user) {
		super();
		this.book = book;
		this.user = user;
	}
	
	public void returnBook() {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            book.setBorrowerId(null);
            System.out.println(user.getName() + " has returned " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not borrowed.");
        }
    }
	
	
	

}
