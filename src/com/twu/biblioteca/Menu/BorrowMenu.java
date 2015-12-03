package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Library.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 3/12/2015.
 */
public class BorrowMenu {

    private Scanner input;
    private Library library;

    public BorrowMenu(Library library){

        this.library = library;
        input = new Scanner(System.in);

    }

    public void displayBorrowMenu(int option){
            try {
                System.out.println("Select a book to borrow by entering the ID number or enter 0 to go back to the main menu:");
                System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                System.out.print("Enter your option:");
                option = input.nextInt();
            }
            catch(InputMismatchException e){
                input.nextLine();
            }
            borrowMenuOptions(option);
    }

    public void borrowMenuOptions(int option){

        if (option == 0) {
            System.out.print("\n");
            return;
        }

        if (option > 0 && option <= library.getAvailableBooks().size()) {
            try {
                Book bookToBorrow = library.getAvailableBooks().get(option - 1);
                library.checkoutBook(bookToBorrow);
                System.out.println("\nThank you! Enjoy reading " + bookToBorrow.getTitle().toString() + "!");
                System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        } else {
            System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}