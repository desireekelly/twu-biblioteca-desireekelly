package com.twu.biblioteca.MenuTests;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Menu.Utilities;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Utilities class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Utilities
 */
public class UtilitiesTest {

    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
    }

    @Test
    public void testDisplayFormattedBookList() throws Exception {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        assertEquals("1               Java 101        Joe Bloggs      1990           \n" +
                        "2               PHP 101         Mary Jane       2005           \n",
                Utilities.displayFormattedBookList(books).toString());
    }
}