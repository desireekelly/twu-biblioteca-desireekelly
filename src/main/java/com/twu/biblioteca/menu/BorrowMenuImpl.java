package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * BorrowMenu implementation.
 * BorrowMenu is responsible for handling the borrow menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BorrowMenuImpl implements BorrowMenu {

    private Scanner input;
    private PrintStream outputStream;
    private Library library;
    private Messages messages;
    private boolean exit;

    /**
     * Construct a borrow menu with access to the library, input streams and output streams.
     */
    public BorrowMenuImpl(Library library, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.messages = messages;
        exit = false;
    }

    /**
     * Display the borrow menu options.
     */
    @Override
    public void displayBorrowMenu() {
        outputStream.print(messages.borrowMessage());
        outputStream.print(messages.bookListingMessage());
        outputStream.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
        outputStream.print(messages.optionMessage());
        do {
            try {
                if (input.hasNextLine()) {
                    borrowMenuOptions(input.nextInt(10));
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
     * Dispatch to borrow a book.
     *
     * @param option The option entered on the borrow menu.
     */
    /* package */ void borrowMenuOptions(int option) {
        if (option == 0) {
            outputStream.print("\n");
            exit = true;
            return;
        }
        if (option > 0 && option <= library.getAvailableBooks().size()) {
            try {
                Book bookToBorrow = library.getAvailableBooks().get(option - 1);
                library.checkoutBook(bookToBorrow);
                outputStream.println(messages.borrowThankYouMessage() + bookToBorrow.getTitle().toString() + "!\n");
                exit = true;
            } catch (BookNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            outputStream.print(messages.incorrectInputMessage());
            exit = true;
        }
    }
}