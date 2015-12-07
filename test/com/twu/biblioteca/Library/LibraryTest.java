package com.twu.biblioteca.Library;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Exceptions.MovieNotBorrowable;
import com.twu.biblioteca.Movie.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Library class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Library
 */
public class LibraryTest {

    // Books in the library
    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);
    public static final Book BOOK_3 = new Book("C# 101", "John Smith", 2010);
    public static final Book BOOK_4 = new Book("C++ 101", "Joyce Merry", 2001);

    //Movies in the library
    public static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", 10);
    public static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", 8);
    public static final Movie MOVIE_3 = new Movie("Divergent", 2014, "Neil Burger", -1);
    public static final Movie MOVIE_4 = new Movie("The Bourne Identity", 2002, "Doug Liman", 10);

    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
        assertEquals(BOOK_3, library.getBookList().get(2));
        assertEquals(BOOK_4, library.getBookList().get(3));
    }

    @Test
    public void testCreateMovieList() throws Exception {
        assertEquals(MOVIE_1, library.getMovieList().get(0));
        assertEquals(MOVIE_2, library.getMovieList().get(1));
        assertEquals(MOVIE_3, library.getMovieList().get(2));
        assertEquals(MOVIE_4, library.getMovieList().get(3));
    }

    @Test
    public void testCheckoutBook() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
    }

    @Test
    public void testReturnBook() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        library.returnBook(library.getBookList().get(0));
    }

    @Test(expected = BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws Exception {
        library.returnBook(library.getBookList().get(0));
    }

    @Test(expected = BookNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        library.checkoutBook(library.getBookList().get(0));
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        assertTrue(library.getBorrowedBooks().contains(BOOK_1));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        assertFalse(library.getAvailableBooks().contains(BOOK_1));

        library.checkoutBook(library.getBookList().get(1));
        assertFalse(library.getAvailableBooks().contains(BOOK_2));
    }

    @Test
    public void testCheckoutMovie() throws Exception {
        library.checkoutMovie(library.getMovieList().get(0));
    }

    @Test
    public void testGetAvailableMovies() throws Exception {
        library.checkoutMovie(library.getMovieList().get(0));
        assertFalse(library.getAvailableMovies().contains(MOVIE_1));

        library.checkoutMovie(library.getMovieList().get(1));
        assertFalse(library.getAvailableMovies().contains(MOVIE_2));
    }

    @Test
    public void testGetBorrowedMovies() throws Exception {
        library.checkoutMovie(library.getMovieList().get(0));
        assertTrue(library.getBorrowedMovies().contains(MOVIE_1));
    }

    @Test(expected = MovieNotBorrowable.class)
    public void testExceptionThrownWhenMovieBorrowedTwice() throws Exception {
        library.checkoutMovie(library.getMovieList().get(0));
        library.checkoutMovie(library.getMovieList().get(0));
    }
}