package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.Book;

public class BookStore {
    private List<Book> books;

    public BookStore() {
        books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public Book searchByTitle(String title) {
        Optional<Book> book = books.stream()
                                   .filter(b -> b.getTitle().equalsIgnoreCase(title))
                                   .findFirst();
        return book.orElse(null);
    }

    public Book searchByAuthor(String author) {
        Optional<Book> book = books.stream()
                                   .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                                   .findFirst();
        return book.orElse(null);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
