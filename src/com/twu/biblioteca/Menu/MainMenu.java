package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Utilities.Message;
import com.twu.biblioteca.Utilities.Utilities;

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
    private Library library;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;

    /**
     * Construct a main menu with access to the Library.
     */
    public MainMenu(Library library) {
        this.library = library;
        input = new Scanner(System.in);
        borrowMenu = new BorrowMenu(library);
        returnMenu = new ReturnMenu(library);
    }

    /**
     * Display the main menu options.
     */
    public void mainMenu() {

        System.out.println(Message.welcomeMessage());

        while (true) {
            try {
                System.out.print(Message.mainMenuMessage());
                mainMenuOptions(input.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(Message.errorMessage());
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
                System.out.print("\n");
                System.out.println("Available Books: \n");
                System.out.printf("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
                System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                System.out.print("\n");
                if (library.getAvailableBooks().isEmpty()) {
                    System.out.println("Sorry, there are no available books to borrow\n");
                    break;
                }
                borrowMenu.displayBorrowMenu();
                break;
            case 3:
                System.out.print("\n");
                if (library.getBorrowedBooks().isEmpty()) {
                    System.out.println("Sorry, there are no available books to return\n");
                    break;
                }
                returnMenu.displayReturnMenu();
                break;
            case 4:
                System.out.println("\nThank you for using the Bangalore Public Library!");
                System.exit(0);
            default:
                System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}