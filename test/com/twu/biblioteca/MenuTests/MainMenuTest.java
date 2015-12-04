package com.twu.biblioteca.MenuTests;

import com.twu.biblioteca.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

/**
 * Tests for the MainMenu class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see MainMenu
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

    @Test(expected = InputMismatchException.class)
    public void testExceptionThrownWithInvalidMenuOption() throws InputMismatchException {
        throw new InputMismatchException();
    }
}