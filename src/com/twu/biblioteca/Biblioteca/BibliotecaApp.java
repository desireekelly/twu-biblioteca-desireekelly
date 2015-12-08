package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.LibraryImpl;
import com.twu.biblioteca.menu.*;

/**
 * BibliotecaApp is responsible for launching the biblioteca library System.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new LibraryImpl();
        BorrowMenu borrowMenu = new BorrowMenuImpl(library, System.in, System.out);
        ReturnMenu returnMenu = new ReturnMenuImpl(library, System.in, System.out);
        MainMenu launch = new MainMenu(library, System.in, System.out, borrowMenu, returnMenu);
        launch.mainMenu();
    }
}