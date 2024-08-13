package com.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("B001", "Java Programming", "John Doe", "Technology", 29.99);
    }

    @Test
    public void testGetBookID() {
        assertEquals("B001", book.getBookID());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Java Programming", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("John Doe", book.getAuthor());
    }

    @Test
    public void testGetCategory() {
        assertEquals("Technology", book.getCategory());
    }

    @Test
    public void testGetPrice() {
        assertEquals(29.99, book.getPrice());
    }

    @Test
    public void testToString() {
        String expected = "BookId-B001 Book name-Java Programming Author-John Doe Category-Technology Price-29.99";
        assertEquals(expected, book.toString());
    }
}
