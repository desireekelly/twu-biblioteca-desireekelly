package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Messages;
import com.twu.biblioteca.Utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * BorrowMenu is responsible for handling the borrow menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BorrowMenuImpl implements BorrowMenu {

    private Scanner input;
    private PrintStream outputStream;
    private Library library;

    /**
     * Construct a borrow menu with access to the Library, input streams and output streams.
     */
    public BorrowMenuImpl(Library library, InputStream inputStream, PrintStream outputStream) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
    }

    /**
     * Display the borrow menu options.
     */
    @Override
    public void displayBorrowMenu() {
        try {
            outputStream.print(Messages.borrowMessage());
            outputStream.print(Messages.bookListingMessage());
            outputStream.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
            outputStream.print(Messages.optionMessage());
            borrowMenuOptions(input.nextInt(10));
        } catch (InputMismatchException e) {
            outputStream.print(Messages.incorrectInputMessage());
            input.nextLine();
        }
    }

    /**
     * Dispatch to borrow a book.
     *
     * @param option The option entered on the borrow menu.
     */
    /* package */ void borrowMenuOptions(int option) {
        if (option == 0) {
            outputStream.print("\n");
            return;
        }
        if (option > 0 && option <= library.getAvailableBooks().size()) {
            try {
                Book bookToBorrow = library.getAvailableBooks().get(option - 1);
                library.checkoutBook(bookToBorrow);
                outputStream.println(Messages.borrowThankYouMessage() + bookToBorrow.getTitle().toString() + "!\n");
            } catch (BookNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            outputStream.println(Messages.incorrectInputMessage());
        }
    }
}