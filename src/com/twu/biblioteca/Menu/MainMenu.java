package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Messages;
import com.twu.biblioteca.Utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MainMenu is responsible for handling the main menu navigation.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class MainMenu {

    private Scanner input;
    private PrintStream outputStream;
    private Library library;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;

    /**
     * Construct a main menu with access to the Library.
     */
    public MainMenu(Library library, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
    }

    /**
     * Display the main menu options.
     */
    public void mainMenu() {

        System.out.println(Messages.welcomeMessage());

        while (true) {
            try {
                outputStream.print(Messages.mainMenuMessage());
                mainMenuOptions(input.nextInt());
            } catch (InputMismatchException e) {
                outputStream.println(Messages.errorMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Dispatch to available books, borrow, return or exit.
     *
     * @param option The option entered on the main menu.
     */
    public void mainMenuOptions(int option) {
        switch (option) {
            case 1:
                outputStream.print("\n");
                outputStream.println("Available Books: \n");
                outputStream.printf("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
                outputStream.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                outputStream.print("\n");
                if (library.getAvailableBooks().isEmpty()) {
                    outputStream.println("Sorry, there are no available books to borrow\n");
                    break;
                }
                borrowMenu.displayBorrowMenu();
                break;
            case 3:
                outputStream.print("\n");
                if (library.getBorrowedBooks().isEmpty()) {
                    outputStream.println("Sorry, there are no available books to return\n");
                    break;
                }
                returnMenu.displayReturnMenu();
                break;
            case 4:
                outputStream.println("\nThank you for using the Bangalore Public Library!");
                System.exit(0);
            default:
                outputStream.println("\nIncorrect option, please try again.\n");
        }
    }
}