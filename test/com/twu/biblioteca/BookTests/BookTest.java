package com.twu.biblioteca.BookTests;

import com.twu.biblioteca.Book.Book;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Book class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Book
 */
public class BookTest {

    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    @Test
    public void testGetTitle() throws Exception {
        assertEquals(BOOK_1.getTitle(), "Java 101");
    }

    @Test
    public void testGetAuthor() throws Exception {
        assertEquals(BOOK_1.getAuthor(), "Joe Bloggs");
    }

    @Test
    public void testGetYearPublished() throws Exception {
        assertEquals(BOOK_1.getYearPublished(), 1990);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(BOOK_1.toString(), "Java 101, Joe Bloggs, 1990");
    }

    @Test
    public void testIfTwoBooksAreTheSame() throws Exception {
        assertTrue(BOOK_1.equals(BOOK_1));
        assertFalse(BOOK_1.equals(BOOK_2));
    }
}