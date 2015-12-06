package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ReturnMenu is responsible for handling the return menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class ReturnMenuImpl implements ReturnMenu {

    private Library library;
    private Scanner input;
    private PrintStream outputStream;

    /**
     * Construct a return menu with access to the Library.
     */
    public ReturnMenuImpl(Library library, InputStream inputStream, PrintStream outputStream) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
    }

    /**
     * Display the return menu options.
     */
    @Override
    public void displayReturnMenu() {
        try {
            outputStream.println("\nSelect a book to return by entering the ID number or enter 0 to go back to the main menu:\n");
            outputStream.printf("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
            outputStream.println(Utilities.displayFormattedBookList(library.getBorrowedBooks()));
            outputStream.print("Enter your option:");
            returnMenuOptions(input.nextInt(10));
        } catch (InputMismatchException e) {
            outputStream.println("\nIncorrect option, please try again.\n");
            input.nextLine();
        }
    }

    /**
     * Dispatch to return a book.
     *
     * @param option The option entered on the return menu.
     */
    /* package */ void returnMenuOptions(int option) {
        if (option == 0) {
            outputStream.print("\n");
            return;
        }
        if (option > 0 && option <= library.getBorrowedBooks().size()) {
            try {
                Book bookToReturn = library.getBorrowedBooks().get(option - 1);
                library.returnBook(bookToReturn);
                outputStream.println("\nThank you for returning " + bookToReturn.getTitle().toString() + "!\n");
            } catch (BookNotReturnable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            outputStream.println("\nIncorrect option, please try again.\n");
        }
    }
}