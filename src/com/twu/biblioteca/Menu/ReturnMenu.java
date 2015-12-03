package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Desiree Kelly on 3/12/2015.
 */
public class ReturnMenu {

    private Library library;
    private Scanner input;

    public ReturnMenu(Library library) {
        this.library = library;
        input = new Scanner(System.in);
    }

    public void displayReturnMenu(int option){
        try {
            System.out.println("Select a book to return by entering the ID number or enter 0 to go back to the main menu:");
            System.out.println(Utilities.displayFormattedBookList(library.getBorrowedBooks()));
            System.out.print("Enter your option:");
            option = input.nextInt();
        }
        catch(InputMismatchException e){
            input.nextLine();
        }
        returnMenuOptions(option);
    }

    public void returnMenuOptions(int option){
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