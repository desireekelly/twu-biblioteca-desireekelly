package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the MainMenu class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see MainMenu
 */
public class MainMenuTest {


    @Test
    public void testMainMenu() throws Exception {


    }

    @Test
    public void testMainMenuOptionsCase1() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary() {
            @Override
            public List<Book> getAvailableBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }
        };
        BorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();

        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(1);

        String output = baos.toString();
        assertEquals("\nAvailable Books: \n\n" +
                        "ID:             Title:          Author:         Year Published:\n" +
                        "1               Unit Testing 101 Uncle Bob       1947           \n\n",
                output);

    }

    @Test
    public void testMainMenuOptionsCase2EmptyLibrary() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        MockBorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();

        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(2);

        String output = baos.toString();
        assertEquals("\n" +
                        "Sorry, there are no available books to borrow\n" +
                        "\n",
                output);
        assertFalse(borrowMenu.displayBorrowMenuCalled);

    }

    @Test
    public void testMainMenuOptionsCase2PopulatedLibrary() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary() {
            @Override
            public List<Book> getAvailableBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }
        };
        MockBorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();

        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(2);

        String output = baos.toString();
        assertEquals("\n", output);
        assertTrue(borrowMenu.displayBorrowMenuCalled);

    }

    static class MockLibrary implements Library {
        @Override
        public List<Book> getAvailableBooks() {
            return Collections.emptyList();
        }

        @Override
        public List<Book> getBorrowedBooks() {
            return Collections.emptyList();
        }

        @Override
        public List<Book> getBookList() {
            return Collections.emptyList();
        }

        @Override
        public void checkoutBook(Book book) throws BookNotBorrowable {

        }

        @Override
        public void returnBook(Book book) throws BookNotReturnable {

        }
    }

    static class MockBorrowMenu implements BorrowMenu {
        public boolean displayBorrowMenuCalled = false;
        @Override
        public void displayBorrowMenu() {
            displayBorrowMenuCalled = true;
        }
    }

    static class MockReturnMenu implements ReturnMenu {
        public boolean displayReturnMenuCalled = false;
        @Override
        public void displayReturnMenu() {
            displayReturnMenuCalled = true;

        }
    }

}