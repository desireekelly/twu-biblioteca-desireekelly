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

    public BorrowMenu(){

        library = new Library();
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

    switch (option) {

        case 1:
            try {
                Book bookToBorrow = library.getAvailableBooks().get(0);
                library.checkoutBook(bookToBorrow);
                System.out.println("\nThank you! Enjoy reading " + bookToBorrow.getTitle().toString() + "!");
                System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
            break;
        case 2:
            try {
                library.checkoutBook(library.getAvailableBooks().get(1));
                System.out.println("\nThank you! Enjoy reading " + library.getAvailableBooks().get(1).getTitle().toString() + "!");
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
            break;
        case 3:
            try {
                library.checkoutBook(library.getAvailableBooks().get(2));
                System.out.println("\nThank you! Enjoy reading " + library.getAvailableBooks().get(2).getTitle().toString() + "!");
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
            break;
        case 4:
            try {
                library.checkoutBook(library.getAvailableBooks().get(3));
                System.out.println("\nThank you! Enjoy reading " + library.getAvailableBooks().get(3).getTitle().toString() + "!");
            } catch (BookNotBorrowable e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
            break;
        case 0:
            System.out.print("\n");
            return;
        default:
            System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}