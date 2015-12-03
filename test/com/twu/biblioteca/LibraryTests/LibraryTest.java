package com.twu.biblioteca.LibraryTests;

import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class LibraryTest {

    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals("Java 101", library.getBookList().get(0).getTitle());
        assertEquals("PHP 101", library.getBookList().get(1).getTitle());
        assertEquals("C# 101", library.getBookList().get(2).getTitle());
        assertEquals("C++ 101", library.getBookList().get(3).getTitle());
    }

    @Test
    public void testCheckoutBook() throws BookNotBorrowable{
        library.checkoutBook(library.getBookList().get(0));
    }

    @Test
    public void testReturnBook() throws BookNotReturnable, BookNotBorrowable {
        library.checkoutBook(library.getBookList().get(0));
        library.returnBook(library.getBookList().get(0));
    }

    @Test(expected=BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws BookNotReturnable{
        library.returnBook(library.getBookList().get(0));
    }

    @Test(expected=BookNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws BookNotBorrowable{
        library.checkoutBook(library.getBookList().get(0));
        library.checkoutBook(library.getBookList().get(0));
    }

    @Test
    public void testGetBookList() throws Exception {
        assertEquals(library.getBookList().get(0).toString(), "1, Java 101, Joe Bloggs, 1990");
        assertEquals(library.getBookList().get(1).toString(), "2, PHP 101, Mary Jane, 2005");
        assertEquals(library.getBookList().get(2).toString(), "3, C# 101, John Smith, 2010");
        assertEquals(library.getBookList().get(3).toString(), "4, C++ 101, Joyce Merry, 2001");
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        assertTrue(library.getBorrowedBooks().toString().contains("1, Java 101, Joe Bloggs, 1990"));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutBook(library.getBookList().get(0));
        library.checkoutBook(library.getBookList().get(1));
        assertEquals(library.getAvailableBooks(),"3, C# 101, John Smith, 2010\n4, C++ 101, Joyce Merry, 2001\n");
    }
}