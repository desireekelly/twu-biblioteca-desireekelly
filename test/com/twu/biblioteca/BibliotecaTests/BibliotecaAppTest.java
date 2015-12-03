package com.twu.biblioteca.BibliotecaTests;

import com.twu.biblioteca.Biblioteca.BibliotecaApp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaAppTest {

    private BibliotecaApp biblioteca;

    @Before
    public void setUp() throws Exception {
    biblioteca = new BibliotecaApp();
    }

    @Test
    public void displayFormattedStrings() throws Exception {
        String books = "Java 101, Joe Bloggs, 1990";
        assertEquals(biblioteca.displayFormattedStrings(books.toString()), "Java 101        Joe Bloggs      1990           \n");
    }
}