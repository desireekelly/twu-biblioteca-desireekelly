package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.customer.Customer;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;
import com.twu.biblioteca.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the library class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Library
 */
public class LibraryTest {

    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    public static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    public static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");

    public static final Customer CUSTOMER_1 = new Customer("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "f8kf93jd");
    public static final Customer CUSTOMER_2 = new Customer("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "5jgfdkl5");

    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
    }

    @Test
    public void testCreateMovieList() throws Exception {
        assertEquals(MOVIE_1, library.getMovieList().get(0));
        assertEquals(MOVIE_2, library.getMovieList().get(1));
    }

    @Test
    public void testCreateCustomerList() throws Exception {
        assertEquals(CUSTOMER_1, library.getCustomerList().get(0));
        assertEquals(CUSTOMER_2, library.getCustomerList().get(1));
    }

    @Test
    public void testCheckoutBook() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertEquals(BOOK_1, library.getBorrowedBooks().get(0));
    }

    @Test
    public void testReturnBook() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertEquals(BOOK_1, library.getBorrowedBooks().get(0));
        library.returnBook(library.getBorrowedBooks().get(0));
        assertEquals(BOOK_1, library.getAvailableBooks().get(0));
    }

    @Test(expected = BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws Exception {
        try {
            library.returnBook(library.getAvailableBooks().get(0));
        } catch (BookNotReturnable e) {
            String message = "book is already returned";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("BookNotReturnable Exception not thrown");
    }

    @Test(expected = BookNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws Exception {
        try {
            library.checkoutBook(library.getBookList().get(0));
            library.checkoutBook(library.getBookList().get(0));
        } catch (BookNotBorrowable e) {
            String message = "book is not available";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("BookNotBorrowable Exception not thrown");
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertTrue(library.getBorrowedBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertTrue(library.getBorrowedBooks().contains(BOOK_2));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertFalse(library.getAvailableBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertFalse(library.getAvailableBooks().contains(BOOK_2));
    }

    @Test
    public void testCheckoutMovie() throws Exception {
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertEquals(MOVIE_1, library.getBorrowedMovies().get(0));
    }

    @Test
    public void testGetAvailableMovies() throws Exception {
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertFalse(library.getAvailableMovies().contains(MOVIE_1));
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertFalse(library.getAvailableMovies().contains(MOVIE_2));
    }

    @Test
    public void testGetBorrowedMovies() throws Exception {
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertTrue(library.getBorrowedMovies().contains(MOVIE_1));
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertTrue(library.getBorrowedMovies().contains(MOVIE_2));
    }

    @Test(expected = MovieNotBorrowable.class)
    public void testExceptionThrownWhenMovieBorrowedTwice() throws Exception {
        try {
            library.checkoutMovie(library.getMovieList().get(0));
            library.checkoutMovie(library.getMovieList().get(0));
        } catch (MovieNotBorrowable e) {
            String message = "movie is not available";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("MovieNotBorrowable Exception not thrown");
    }
}