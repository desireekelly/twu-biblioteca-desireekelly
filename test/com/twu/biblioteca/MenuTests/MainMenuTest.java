package com.twu.biblioteca.MenuTests;

import org.junit.Before;
import org.junit.Test;
import java.util.InputMismatchException;

/**
 * Created by Desiree Kelly on 4/12/2015.
 */
public class MainMenuTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMainMenu() throws Exception {

    }

    @Test
    public void testMainMenuOptions() throws Exception {

    }

    @Test(expected=InputMismatchException.class)
    public void testExceptionThrownWithInvalidMenuOption() throws InputMismatchException{
        throw new InputMismatchException();
    }
}