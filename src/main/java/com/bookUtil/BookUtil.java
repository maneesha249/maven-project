package com.bookUtil;

import java.util.Scanner;

import com.model.Book;
import com.service.BookStore;

public class BookUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore bs=new BookStore();
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=3;i++) {
			try {
				String bookID=sc.nextLine();
				validateBookID(bookID);
				String title=sc.nextLine();
				String author=sc.nextLine();
				String category=sc.nextLine();
				validateCategory(category);
				float price=sc.nextFloat();
				validatePrice(price);
				Book book=new Book(bookID,title,author,category,price);
				bs.addBook(book);
			}
			catch(InvalidBookException e) {
				System.out.println(e.getMessage());
			}
		}
		String searchTitle=sc.nextLine();
		bs.searchByTitle(searchTitle);
		String searchAuthor=sc.nextLine();
		bs.searchByAuthor(searchAuthor);
		bs.displayAll();
	}

	private static void validatePrice(float price) throws InvalidBookException {
		if(price<0) {
			throw new InvalidBookException("Price cannot be negative");
		}
	}

	private static void validateCategory(String category) throws InvalidBookException {
		if(!(category.equalsIgnoreCase("Science")||category.equalsIgnoreCase("Fiction")||category.equalsIgnoreCase("Technology")||category.equalsIgnoreCase("Others"))) {
			throw new InvalidBookException("Category must be 'Science','Fiction','Technology',or 'Others'.");
		}
		
	}

	private static void validateBookID(String bookID) throws InvalidBookException {
		if(bookID.length()!=4||!bookID.startsWith("B")) {
			throw new InvalidBookException("Book ID must start with 'B' and be 4 characters");
		}
		
	}

}
