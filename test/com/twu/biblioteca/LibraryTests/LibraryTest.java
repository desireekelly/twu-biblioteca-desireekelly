package com.twu.biblioteca.LibraryTests;

import com.twu.biblioteca.Library.Library;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class LibraryTest {

    Library library;

    @Before
    public void setUp() throws Exception {
    library = new Library();
    }

    @Test
    public void testCreateBookList() throws Exception {

    }

    @Test
    public void testGetBookList() throws Exception {

    }

    @Test
    public void testCheckoutBook(){
        assertEquals(library.checkoutBook(), null);
    }

    @Test
    public void testReturnBook(){
        assertEquals(library.returnBook(), null);

    }
}