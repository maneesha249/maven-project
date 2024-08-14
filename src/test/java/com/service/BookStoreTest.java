package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.Book;

public class BookStoreTest {

    private BookStore bookStore;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        bookStore = new BookStore();
        book1 = new Book("B001", "Java Programming", "John Doe", "Technology", 29.99);
        book2 = new Book("B002", "Advanced Java", "Jane Doe", "Technology", 39.99);
        bookStore.addBook(book1);
        bookStore.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("B003", "Spring Framework", "John Smith", "Technology", 49.99);
        bookStore.addBook(book3);
        assertEquals(book3, bookStore.searchByTitle("Spring Framework"));
    }

    @Test
    public void testSearchByTitle() {
        Book foundBook = bookStore.searchByTitle("Java Programming");
        assertEquals(book1, foundBook);
    }

    @Test
    public void testSearchByAuthor() {
        Book foundBook = bookStore.searchByAuthor("Jane Doe");
        assertEquals(book2, foundBook);
    }

    @Test
    public void testDisplayAll() {
        List<Book> allBooks = bookStore.getAllBooks();
        String expectedOutput = "[" + "BookId-B001 Book name-Java Programming Author-John Doe Category-Technology Price-29.99, " 
                            + "BookId-B002 Book name-Advanced Java Author-Jane Doe Category-Technology Price-39.99" + "]";
        String actualOutput = allBooks.toString();
        assertEquals(expectedOutput, actualOutput);
    }
}
