package com.twu.biblioteca.utilities;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.List;

/**
 * utilities is responsible for formatting a list of books into columns.
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

        for (Book book : bookList) {
            index++;
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }

    public static String displayFormattedMovieList(List<Movie> movieList){
        String formattedMovieList = "";
        int index = 0;

        for (Movie movie : movieList) {
            index++;
            formattedMovieList += String.format("%-20d %-20s %-20d %-35s %-20s\n", index, movie.getName(), movie.getYear(), movie.getDirector(), movie.getMovieRating());
        }
        return formattedMovieList;
    }
}