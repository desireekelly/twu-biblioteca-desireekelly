package com.twu.biblioteca.BookTests;

import com.twu.biblioteca.Book.Book;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception{
    book = new Book(1, "Java 101", "Joe Bloggs", 1990);
    }

    @Test
    public void testGetId() throws Exception{
        assertEquals(book.getId(), 1);
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
        assertEquals(book.toString(), "1, Java 101, Joe Bloggs, 1990");
    }
}