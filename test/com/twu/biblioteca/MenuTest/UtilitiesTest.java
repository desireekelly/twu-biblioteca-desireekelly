package com.twu.biblioteca.MenuTest;

import java.util.List;
import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Menu.Utilities;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Desiree Kelly on 3/12/2015.
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
        assertTrue(Utilities.displayFormattedBookList(books).contains("1               Java 101        Joe Bloggs      1990"));
    }
}