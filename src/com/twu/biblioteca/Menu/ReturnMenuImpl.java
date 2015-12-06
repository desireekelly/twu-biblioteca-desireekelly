package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Messages;
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
    private boolean exit;

    /**
     * Construct a return menu with access to the Library, input streams and output streams.
     */
    public ReturnMenuImpl(Library library, InputStream inputStream, PrintStream outputStream) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        exit = false;
    }

    /**
     * Display the return menu options.
     */
    @Override
    public void displayReturnMenu() {
        outputStream.print(Messages.returnMessage());
        outputStream.printf(Messages.bookListingMessage());
        outputStream.println(Utilities.displayFormattedBookList(library.getBorrowedBooks()));
        outputStream.print(Messages.optionMessage());
        do {
            try {
                if(input.hasNextLine()) {
                    returnMenuOptions(input.nextInt(10));
                }else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                outputStream.print(Messages.incorrectInputMessage());
                input.nextLine();
            }
        }while(!exit);
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
                outputStream.println(Messages.returnThankYouMessage() + bookToReturn.getTitle().toString() + "!\n");
                exit = true;
            } catch (BookNotReturnable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            outputStream.println(Messages.incorrectInputMessage());
        }
    }
}