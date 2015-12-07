package com.twu.biblioteca.Utilities;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Customer.Customer;
import com.twu.biblioteca.Movie.Movie;

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
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, b.getTitle(), b.getAuthor(), b.getYearPublished());
        }
        return formattedBookList;
    }

    public static String displayFormattedMovieList(List<Movie> movieList){
        String formattedMovieList = "";
        int index = 0;

        for (Movie m : movieList) {
            index++;
            formattedMovieList += String.format("%-20d %-20s %-20d %-35s %-20s\n", index, m.getName(), m.getYear(), m.getDirector(), m.getMovieRating());
        }
        return formattedMovieList;
    }
}