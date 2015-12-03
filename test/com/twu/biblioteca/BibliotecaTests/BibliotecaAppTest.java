package com.twu.biblioteca.BibliotecaTests;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Biblioteca.BibliotecaApp;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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

    @Test(expected=InputMismatchException.class)
    public void testExceptionThrownWithInvalidMenuOption() throws InputMismatchException{
        throw new InputMismatchException();
    }
}