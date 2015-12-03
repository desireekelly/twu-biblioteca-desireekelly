package com.twu.biblioteca.LibraryTests;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the Library class.
 *
 * @see Library
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryTest {

    // Books in the library
    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);
    public static final Book BOOK_3 = new Book("C# 101", "John Smith", 2010);
    public static final Book BOOK_4 = new Book("C++ 101", "Joyce Merry", 2001);

    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
        assertEquals(BOOK_3, library.getBookList().get(2));
        assertEquals(BOOK_4, library.getBookList().get(3));
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

    @Test(expected=BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws Exception{
        library.returnBook(library.getBookList().get(0));
    }

    @Test(expected=BookNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws Exception{
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
}