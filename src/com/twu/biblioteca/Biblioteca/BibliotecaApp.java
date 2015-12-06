package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.LibraryImpl;
import com.twu.biblioteca.Menu.*;

/**
 * BibliotecaApp is responsible for launching the Biblioteca Library System.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new LibraryImpl();
        BorrowMenu borrowMenu = new BorrowMenuImpl(library, System.in, System.out);
        ReturnMenu returnMenu = new ReturnMenuImpl(library);
        MainMenu launch = new MainMenu(library, System.in, System.out, borrowMenu, returnMenu);
        launch.mainMenu();
    }
}