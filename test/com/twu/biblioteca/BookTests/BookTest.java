package com.twu.biblioteca.BookTests;

import com.twu.biblioteca.Book.Book;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the Book class.
 *
 * @see Book
 * @author Desiree Kelly
 * @version 1.0
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception{
    book = new Book("Java 101", "Joe Bloggs", 1990);
    }

    @Test
    public void testGetTitle() throws Exception{
        assertEquals(book.getTitle(), "Java 101");
    }

    @Test
    public void testGetAuthor() throws Exception{
        assertEquals(book.getAuthor(), "Joe Bloggs");
    }

    @Test
    public void testGetYearPublished() throws Exception{
        assertEquals(book.getYearPublished(), 1990);
    }

    @Test
    public void testToString() throws Exception{
        assertEquals(book.toString(), "Java 101, Joe Bloggs, 1990");
    }
}