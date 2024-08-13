package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Book;

public class BookStore {
private List<Book>books;
public BookStore() {
	books=new ArrayList<>();
}
public void addBook(Book b) {
	books.add(b);
	System.out.println("book added successfully");
}
public void searchByTitle(String title) {
	books.stream().filter(b->b.getTitle().equalsIgnoreCase(title)).findFirst();
}
public void searchByAuthor(String author) {
	books.stream().filter(b->b.getAuthor().equalsIgnoreCase(author)).findFirst();
}
public void displayAll() {
	System.out.println(books);
}
}
