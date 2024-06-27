package com.monocept.test;

import com.monocept.model.Book;
import com.monocept.model.BorrowBook;
import com.monocept.model.CatalogBook;
import com.monocept.model.RegisterUser;
import com.monocept.model.ReturnBook;
import com.monocept.model.User;

public class LibraryManagementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book book = new Book("Harry Potter", "JK Rowling", false);
		User user = new User("Abhi", "1");
		RegisterUser userRegister = new RegisterUser(user);
		userRegister.userRegistration();
		
		BorrowBook borrowingBook = new BorrowBook(book, user);
		borrowingBook.borrowBook();
		
		CatalogBook catalog = new CatalogBook(book);
		catalog.catalogBook();
		
		ReturnBook returningBook = new ReturnBook(book, user);
		returningBook.returnBook();
		

	}

}
