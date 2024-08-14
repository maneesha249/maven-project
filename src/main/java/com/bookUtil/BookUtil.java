package com.bookUtil;

import java.util.List;
import java.util.Scanner;
import com.model.Book;
import com.service.BookStore;
import com.service.InvalidBookException;

public class BookUtil {

    public static void main(String[] args) {
        BookStore bs = new BookStore();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println("Enter Book ID:");
                String bookID = sc.nextLine();
                validateBookID(bookID);

                System.out.println("Enter Title:");
                String title = sc.nextLine();

                System.out.println("Enter Author:");
                String author = sc.nextLine();

                System.out.println("Enter Category:");
                String category = sc.nextLine();
                validateCategory(category);

                System.out.println("Enter Price:");
                float price = sc.nextFloat();
                validatePrice(price);
                sc.nextLine();  // Consume the remaining newline

                Book book = new Book(bookID, title, author, category, price);
                bs.addBook(book);
                System.out.println("Book added successfully.");
            } catch (InvalidBookException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Enter title to search:");
        String searchTitle = sc.nextLine();
        Book foundBookByTitle = bs.searchByTitle(searchTitle);
        if (foundBookByTitle != null) {
            System.out.println("Found book by title: " + foundBookByTitle);
        } else {
            System.out.println("No book found with the given title.");
        }

        System.out.println("Enter author to search:");
        String searchAuthor = sc.nextLine();
        Book foundBookByAuthor = bs.searchByAuthor(searchAuthor);
        if (foundBookByAuthor != null) {
            System.out.println("Found book by author: " + foundBookByAuthor);
        } else {
            System.out.println("No book found with the given author.");
        }

        System.out.println("All books in the store:");
        List<Book> books = bs.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void validatePrice(float price) throws InvalidBookException {
        if (price < 0) {
            throw new InvalidBookException("Price cannot be negative");
        }
    }

    private static void validateCategory(String category) throws InvalidBookException {
        if (!(category.equalsIgnoreCase("Science") ||
              category.equalsIgnoreCase("Fiction") ||
              category.equalsIgnoreCase("Technology") ||
              category.equalsIgnoreCase("Others"))) {
            throw new InvalidBookException("Category must be 'Science', 'Fiction', 'Technology', or 'Others'.");
        }
    }

    private static void validateBookID(String bookID) throws InvalidBookException {
        if (bookID.length() != 4 || !bookID.startsWith("B")) {
            throw new InvalidBookException("Book ID must start with 'B' and be 4 characters long.");
        }
    }
}
