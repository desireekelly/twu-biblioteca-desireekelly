package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Utilities;

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
    private Library library;

    /**
     * Construct a borrow menu with access to the Library.
     */
    public BorrowMenuImpl(Library library) {
        this.library = library;
        input = new Scanner(System.in);
    }

    /**
     * Display the borrow menu options.
     */
    @Override
    public void displayBorrowMenu() {
        try {
            System.out.println("Select a book to borrow by entering the ID number or enter 0 to go back to the main menu:");
            System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
            System.out.print("Enter your option:");
            borrowMenuOptions(input.nextInt(10));
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect option, please try again.\n");
            input.nextLine();
        }
    }

    /**
     * Dispatch to borrow a book.
     *
     * @param option The option entered on the return menu.
     */
    private void borrowMenuOptions(int option) {
        if (option == 0) {
            System.out.print("\n");
            return;
        }
        if (option > 0 && option <= library.getAvailableBooks().size()) {
            try {
                Book bookToBorrow = library.getAvailableBooks().get(option - 1);
                library.checkoutBook(bookToBorrow);
                System.out.println("\nThank you! Enjoy reading " + bookToBorrow.getTitle().toString() + "!\n");
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        } else {
            System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}