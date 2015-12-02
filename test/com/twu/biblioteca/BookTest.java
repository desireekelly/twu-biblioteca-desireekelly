package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp(){
    book = new Book("Java 101", "Joe Bloggs", 1990, true);
    }

    @Test
    public void testGetTitle() {
        assertEquals(book.getTitle(), "Java 101");
    }

    @Test
    public void testGetAuthor(){
        assertEquals(book.getAuthor(), "Joe Bloggs");
    }

    @Test
    public void testGetYearPublished(){
        assertEquals(book.getYearPublished(), 1990);
    }

    @Test
    public void testGetCheckoutStatus(){
        assertEquals(book.getCheckoutStatus(), true);
    }

    @Test
    public void testToString(){
        assertEquals(book.toString(), "Java 101, Joe Bloggs, 1990, true");
    }

}