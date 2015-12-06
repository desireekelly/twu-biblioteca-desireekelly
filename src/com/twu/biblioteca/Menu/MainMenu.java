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
    private boolean exit;

    /**
     * Construct a main menu with access to the Library.
     */
    public MainMenu(Library library, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu) {
        this.library = library;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
        exit = false;
    }

    /**
     * Display the main menu options.
     */
    public void mainMenu() {

        outputStream.print(Messages.welcomeMessage());
        outputStream.print(Messages.mainMenuMessage());
        outputStream.print(Messages.optionMessage());

        while (!exit && input.hasNextLine()) {
            try {
                    mainMenuOptions(input.nextInt());
                if(exit == true){
                    break;
                }
                    outputStream.print(Messages.mainMenuMessage());
                    outputStream.print(Messages.optionMessage());

            } catch (InputMismatchException e) {
                outputStream.print(Messages.incorrectInputMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Dispatch to available books, borrow, return or exit.
     *
     * @param option The option entered on the main menu.
     */
    /* package */ void mainMenuOptions(int option) {
        switch (option) {
            case 1:
                outputStream.print(Messages.bookListingMessage());
                outputStream.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                if (library.getAvailableBooks().isEmpty()) {
                    outputStream.print(Messages.incorrectBorrowMessage());
                    break;
                }
                borrowMenu.displayBorrowMenu();
                break;
            case 3:
                if (library.getBorrowedBooks().isEmpty()) {
                    outputStream.print(Messages.incorrectReturnMessage());
                    break;
                }
                returnMenu.displayReturnMenu();
                break;
            case 4:
                outputStream.print(Messages.exitMessage());
                exit = true;
                break;
            default:
                outputStream.print(Messages.incorrectInputMessage());
                break;
        }
    }
}