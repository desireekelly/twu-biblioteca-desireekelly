package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;
import com.twu.biblioteca.Library.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaApp {

    private Library library;

    public BibliotecaApp(){
        library = new Library();
    }

    public void launchApp() {

        openMenu();
        /*
        System.out.println("Available Books:");
        library.displayAvailableBooks();

        try {
            library.checkoutBook(library.getBookList().get(0));
        }catch(BookNotBorrowable e){
            System.out.println("\n" + e.getMessage());
        }

        System.out.println("\nBorrowed Books:");
        library.displayBorrowedBooks();

        try {
            library.returnBook(library.getBookList().get(0));
        }catch(BookNotReturnable e){
            System.out.println("\n" + e.getMessage());
        }
        */
    }

    public void openMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Bangalore Public Library");

        int option;

        while (true) {
            System.out.print("\nEnter one of the following options:\n" +
                    "1 Display the list of available books to borrow\n" +
                    "2 Borrow a book\n" +
                    "3 Return a book\n" +
                    "4 Exit\n" +
                    "Enter option:");

            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\n");
                    System.out.printf("%-15s %-15s %-15s\n", "Title", "Author", "Year Published");

                    String [] books = library.getAvailableBooks().split("\\r?\\n");

                    for(String b: books) {
                            String []  token = b.split(", ");
                            System.out.printf("%-15s %-15s %-15s\n", token[0], token[1], token[2]);
                    }
                    break;
                case 2:
                    System.out.print("\n");
                    System.out.print("Borrow book process\n");
                    break;
                case 3:
                    System.out.print("\n");
                    System.out.print("Return book process\n");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Incorrect option, please try again.");
            }
        }
    }
}
