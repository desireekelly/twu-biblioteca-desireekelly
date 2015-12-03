package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Library.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 3/12/2015.
 */
public class MainMenu {

    private Scanner input;
    private int option;
    private Library library;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;

    public MainMenu(Library library){

        this.library = library;
        input = new Scanner(System.in);
        borrowMenu = new BorrowMenu(library);
        returnMenu = new ReturnMenu(library);

    }

    public void mainMenu(){
        System.out.println("Welcome to the Bangalore Public Library!\n");
        System.out.println("We know you'll find a book here that you love!\n");

        while(true) {
            try {
                System.out.print("Enter one of the following options:\n" +
                        "1 Display the list of available books to borrow\n" +
                        "2 Borrow a book\n" +
                        "3 Return a book\n" +
                        "4 Exit\n" +
                        "Enter your option:");
                option = input.nextInt();

            }
            catch(InputMismatchException e){
                input.nextLine();
            }
            mainMenuOptions(option);
        }
    }

    public void mainMenuOptions(int option){
        switch(option) {
            case 1:
                System.out.print("\n");
                System.out.println("Available Books: \n");
                System.out.printf("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
                System.out.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                System.out.print("\n");
                borrowMenu.displayBorrowMenu(option);
                break;
            case 3:
                System.out.print("\n");
                System.out.println("Return book process\n");
                break;
            case 4:
                System.out.println("\nThank you for using the Bangalore Public Library!");
                System.exit(0);
            default:
                System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}