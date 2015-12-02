package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2/12/2015.
 */
public class BookTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetTitle() {
        Book book = new Book();
        assertEquals(book.getTitle(), "Book Title");
    }
}