package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ReturnMenu is responsible for handling the return menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class ReturnMenu {

    private Library library;
    private Scanner input;

    /**
     * Construct a return menu with access to the Library.
     */
    public ReturnMenu(Library library) {
        this.library = library;
        input = new Scanner(System.in);
    }

    /**
     * Display the return menu options.
     */
    public void displayReturnMenu() {
        try {
            System.out.println("Select a book to return by entering the ID number or enter 0 to go back to the main menu:");
            System.out.println(Utilities.displayFormattedBookList(library.getBorrowedBooks()));
            System.out.print("Enter your option:");
            returnMenuOptions(input.nextInt(10));
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect option, please try again.\n");
            input.nextLine();
        }
    }

    /**
     * Dispatch to return a book.
     *
     * @param option The option entered on the return menu.
     */
    public void returnMenuOptions(int option) {
        if (option == 0) {
            System.out.print("\n");
            return;
        }
        if (option > 0 && option <= library.getBorrowedBooks().size()) {
            try {
                Book bookToReturn = library.getBorrowedBooks().get(option - 1);
                library.returnBook(bookToReturn);
                System.out.println("\nThank you for returning " + bookToReturn.getTitle().toString() + "!\n");
            } catch (BookNotReturnable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        } else {
            System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}