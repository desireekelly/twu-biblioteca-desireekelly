package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Exceptions.MovieNotBorrowable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMainMenu() throws Exception {
        String input = "1\n2\n3\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary() {
            @Override
            public List<Book> getAvailableBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }

            @Override
            public List<Book> getBorrowedBooks() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }

            @Override
            public List<Book> getBookList() {
                return Collections.singletonList(new Book("Unit Testing 101", "Uncle Bob", 1947));
            }
        };
        BorrowMenu borrowMenu = new MockBorrowMenu() {
            @Override
            public void displayBorrowMenu() {
                printStream.print("\n\nDisplay Borrow Menu invoked\n\n");
            }
        };
        ReturnMenu returnMenu = new MockReturnMenu() {
            @Override
            public void displayReturnMenu() {
                printStream.print("\n\nDisplay Return Menu invoked\n\n");
            }
        };
        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenu();

        String output = baos.toString();
        assertEquals("Welcome to the Bangalore Public Library!\n" +
                "\n" +
                "We know you'll find a book here that you love!\n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:\n" +
                "Available Books:\n" +
                "\n" +
                "ID:             Title:          Author:         Year Published:\n" +
                "1               Unit Testing 101 Uncle Bob       1947           \n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:\n" +
                "\n" +
                "Display Borrow Menu invoked\n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:\n" +
                "\n" +
                "Display Return Menu invoked\n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:\n" +
                "Thank you for using the Bangalore Public Library!\n", output);
    }

    @Test
    public void testMainMenuKeyboardSmash() throws Exception {
        String input = "fjkasdjfdlsjfl\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        BorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();
        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenu();

        String output = baos.toString();
        assertEquals("Welcome to the Bangalore Public Library!\n" +
                "\n" +
                "We know you'll find a book here that you love!\n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:\n" +
                "Incorrect option, please try again.\n" +
                "\n" +
                "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n" +
                "Enter your option:", output);
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
        assertEquals("\n" +
                        "Available Books:\n" +
                        "\n" +
                        "ID:             Title:          Author:         Year Published:\n" +
                        "1               Unit Testing 101 Uncle Bob       1947           \n" +
                        "\n",
                output);
    }

    @Test
    public void testMainMenuOptionsCase2BooksUnavailableToBorrow() throws Exception {
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
    public void testMainMenuOptionsCase2BooksAvailableToBorrow() throws Exception {
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
        assertEquals("", output);
        assertTrue(borrowMenu.displayBorrowMenuCalled);
    }

    @Test
    public void testMainMenuOptionsCase3BooksUnavailableToReturn() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        BorrowMenu borrowMenu = new MockBorrowMenu();
        MockReturnMenu returnMenu = new MockReturnMenu();

        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(3);

        String output = baos.toString();
        assertEquals("\n" +
                        "Sorry, there are no available books to return\n" +
                        "\n",
                output);
        assertFalse(returnMenu.displayReturnMenuCalled);
    }

    @Test
    public void testMainMenuOptionsCase3BooksAvailableToReturn() throws Exception {
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
        BorrowMenu borrowMenu = new MockBorrowMenu();
        MockReturnMenu returnMenu = new MockReturnMenu();

        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(3);

        String output = baos.toString();
        assertEquals("", output);
        assertTrue(returnMenu.displayReturnMenuCalled);
    }

    @Test
    public void testMainMenuOptionsCase4QuitApplication() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        BorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();
        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(4);

        String output = baos.toString();
        assertEquals("\n" +
                "Thank you for using the Bangalore Public Library!\n", output);
    }

    @Test
    public void testMainMenuOptionsDefaultCase() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        BorrowMenu borrowMenu = new MockBorrowMenu();
        ReturnMenu returnMenu = new MockReturnMenu();
        MainMenu mainMenu = new MainMenu(library, inputStream, printStream, borrowMenu, returnMenu);

        mainMenu.mainMenuOptions(5);

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

        @Override
        public void checkoutMovie(Movie movie) throws MovieNotBorrowable {

        }

        @Override
        public List<Movie> getMovieList(){
            return Collections.emptyList();
        }

        @Override
        public List<Movie> getAvailableMovies(){
            return Collections.emptyList();
        }

        @Override
        public List<Movie> getBorrowedMovies() {
            return Collections.emptyList();
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