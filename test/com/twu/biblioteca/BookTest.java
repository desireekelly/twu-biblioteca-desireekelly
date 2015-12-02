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
    book = new Book();
    }

    @Test
    public void testGetTitle() {
        assertEquals(book.getTitle(), "Title");
    }

    @Test
    public void testGetAuthor(){
        assertEquals(book.getAuthor(), "Author");
    }
}