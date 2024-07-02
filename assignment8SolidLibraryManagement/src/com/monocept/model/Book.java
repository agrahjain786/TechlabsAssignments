package com.monocept.model;

public class Book {
	
	private String title;
	private String author;
	private boolean isBorrowed;
	private String borrowerId;
	private String bookType;

	public Book(String title, String author, boolean isBorrowed, String bookType) {
		super();
		this.title = title;
		this.author = author;
		this.isBorrowed = isBorrowed;
		this.borrowerId = null;
		this.bookType = bookType;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	
	public String getBorrowerId() {
		return borrowerId;
	}


	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}


	public String getBookType() {
		return bookType;
	}


	public void setBookType(String bookType) {
		this.bookType = bookType;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isBorrowed=" + isBorrowed + ", borrowerId="
				+ borrowerId + ", bookType=" + bookType + "]";
	}
	
	

}
