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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the ReturnMenu class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see ReturnMenu
 */
public class ReturnMenuTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDisplayReturnMenu() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();

        ReturnMenu returnMenu = new ReturnMenuImpl(library, inputStream, printStream);

        returnMenu.displayReturnMenu();

        String output = baos.toString();
        assertEquals("\n" +
                "Select a book to return by entering the ID number or enter 0 to go back to the main menu:\n" +
                "\n" +
                "Available Books:\n" +
                "\n" +
                "ID:             Title:          Author:         Year Published:\n" +
                "\n" +
                "Enter your option:", output);
    }

    @Test
    public void testReturnMenuKeyboardSmash() throws Exception {
        String input = "fjkasdjfdlsjfl\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary() {
            @Override
            public List<Book> getBorrowedBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }
        };
        ReturnMenu returnMenu = new ReturnMenuImpl(library, inputStream, printStream);

        returnMenu.displayReturnMenu();

        String output = baos.toString();
        assertEquals("\n" +
                "Select a book to return by entering the ID number or enter 0 to go back to the main menu:\n" +
                "\n" +
                "Available Books:\n" +
                "\n" +
                "ID:             Title:          Author:         Year Published:\n" +
                "1               Unit Testing 101 Uncle Bob       1947           \n" +
                "\n" +
                "Enter your option:\n" +
                "Incorrect option, please try again.\n" +
                "\n", output);
    }

    @Test
    public void testReturnMenuOptionsReturnBook() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary() {
            @Override
            public List<Book> getBorrowedBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }

        };
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream);

        returnMenu.returnMenuOptions(1);

        String output = baos.toString();

        assertEquals("\n" +
                "Thank you for returning Unit Testing 101!\n" +
                "\n", output);
    }

    @Test
    public void testReturnMenuOptionsExit() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream);

        returnMenu.returnMenuOptions(0);

        String output = baos.toString();

        assertEquals("\n", output);
    }

    @Test
    public void testReturnMenuOptionsIncorrectInput() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream);

        returnMenu.returnMenuOptions(5);

        String output = baos.toString();

        assertEquals("\n" +
                "Incorrect option, please try again.\n" +
                "\n", output);
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
}