package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the ReturnMenu class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see ReturnMenu
 */
public class ReturnMenuTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDisplayReturnMenu() throws Exception {

    }

    @Test
    public void testReturnMenuKeyboardSmash() throws Exception {

    }

    @Test
    public void testReturnMenuOptionsReturnBook() throws Exception {

    }

    @Test
    public void testReturnMenuOptionsExit() throws Exception {

    }

    static class MockLibrary implements Library {
        @Override
        public List<Book> getAvailableBooks() {
            return Collections.emptyList();
        }

        @Override
        public List<Book> getBorrowedBooks() {
            return Collections.emptyList();
        }

        @Override
        public List<Book> getBookList() {
            return Collections.emptyList();
        }

        @Override
        public void checkoutBook(Book book) throws BookNotBorrowable {

        }

        @Override
        public void returnBook(Book book) throws BookNotReturnable {

        }
    }
}