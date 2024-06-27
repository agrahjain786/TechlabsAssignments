package com.monocept.model;

public class CatalogBook implements ICatalogBook{
	
	Book book;
	
	
	public CatalogBook(Book book) {
		super();
		this.book = book;
	}


	public void catalogBook() {
		System.out.println(book.getTitle() + " by " + book.getAuthor());
		
	}

}
