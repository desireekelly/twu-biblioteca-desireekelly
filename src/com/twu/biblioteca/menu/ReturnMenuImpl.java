package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ReturnMenu implementation.
 * ReturnMenu is responsible for handling the return menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class ReturnMenuImpl implements ReturnMenu {

    private Library library;
    private Scanner input;
    private PrintStream outputStream;
    private Messages messages;
    private boolean exit;

    /**
     * Construct a return menu with access to the library, input streams and output streams.
     */
    public ReturnMenuImpl(Library library, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.messages = messages;
        exit = false;
    }

    /**
     * Display the return menu options.
     */
    @Override
    public void displayReturnMenu() {
        outputStream.print(messages.returnMessage());
        outputStream.printf(messages.bookListingMessage());
        outputStream.println(Utilities.displayFormattedBookList(library.getBorrowedBooks()));
        outputStream.print(messages.optionMessage());
        do {
            try {
                if (input.hasNextLine()) {
                    returnMenuOptions(input.nextInt(10));
                } else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                outputStream.print(messages.incorrectInputMessage());
                input.nextLine();
                exit = true;
            }
        } while (!exit);
    }

    /**
     * Dispatch to return a book.
     *
     * @param option The option entered on the return menu.
     */
    /* package */ void returnMenuOptions(int option) {
        if (option == 0) {
            outputStream.print("\n");
            exit = true;
            return;
        }
        if (option > 0 && option <= library.getBorrowedBooks().size()) {
            try {
                Book bookToReturn = library.getBorrowedBooks().get(option - 1);
                library.returnBook(bookToReturn);
                outputStream.println(messages.returnThankYouMessage() + bookToReturn.getTitle().toString() + "!\n");
                exit = true;
            } catch (BookNotReturnable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            outputStream.print(messages.incorrectInputMessage());
            exit = true;
        }
    }
}