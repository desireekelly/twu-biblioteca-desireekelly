package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.MainMenu;
import com.twu.biblioteca.Menu.Utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu launch = new MainMenu();
        launch.mainMenu();
    }
}
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
