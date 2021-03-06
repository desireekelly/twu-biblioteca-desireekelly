package com.twu.biblioteca.utilities;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the utilities class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Utilities
 */
public class UtilitiesTest {

    private List<Book> books;
    private List<Movie> movies;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
    }

    @Test
    public void testDisplayFormattedBookList() throws Exception {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        assertEquals("1               Java 101        Joe Bloggs      1990           \n" +
                        "2               PHP 101         Mary Jane       2005           \n",
                Utilities.displayFormattedBookList(books).toString());
    }

    @Test
    public void testDisplayFormattedMovieList() throws Exception {
        movies.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
        assertEquals("1                    The Matrix           1999                 The Wachowski Brothers              10                  \n" +
                        "2                    Inception            2010                 Christopher Nolan                   8                   \n",
                Utilities.displayFormattedMovieList(movies).toString());
    }
}