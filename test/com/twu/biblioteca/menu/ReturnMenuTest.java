package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.customer.Customer;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.MessagesImpl;
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

    @Test
    public void testDisplayReturnMenu() throws Exception {
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        Library library = new MockLibrary();
        Messages messages = new MessagesImpl();

        ReturnMenu returnMenu = new ReturnMenuImpl(library, inputStream, printStream, messages);

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
        Messages messages = new MessagesImpl();
        ReturnMenu returnMenu = new ReturnMenuImpl(library, inputStream, printStream, messages);

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
        Messages messages = new MessagesImpl();
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream, messages);

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
        Messages messages = new MessagesImpl();
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream, messages);

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
        Messages messages = new MessagesImpl();
        ReturnMenuImpl returnMenu = new ReturnMenuImpl(library, inputStream, printStream, messages);

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

        @Override
        public void checkoutMovie(Movie movie) throws MovieNotBorrowable {

        }

        @Override
        public List<Movie> getMovieList() {
            return Collections.emptyList();
        }

        @Override
        public List<Movie> getAvailableMovies() {
            return Collections.emptyList();
        }

        @Override
        public List<Movie> getBorrowedMovies() {
            return Collections.emptyList();
        }

        @Override
        public List<Customer> getCustomerList() {
            return Collections.emptyList();
        }
    }
}