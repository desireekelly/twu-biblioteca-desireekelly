package com.twu.biblioteca.Utilities;

import com.twu.biblioteca.Book.Book;

import java.util.List;

/**
 * Utilities is responsible for formatting a list of books into columns.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class Utilities {

    /**
     * Get a list of books.
     *
     * @return Returns a formatted list of books in columns.
     */
    public static String displayFormattedBookList(List<Book> bookList) {
        String formattedBookList = "";
        int index = 0;

        for (Book b : bookList) {
            index++;
            formattedBookList += String.format("%-15s %-15s %-15s %-15s\n", index, b.getTitle(), b.getAuthor(), b.getYearPublished());
        }
        return formattedBookList;
    }
}