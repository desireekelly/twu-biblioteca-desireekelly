package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.LibraryImpl;
import com.twu.biblioteca.Menu.BorrowMenu;
import com.twu.biblioteca.Menu.MainMenu;
import com.twu.biblioteca.Menu.ReturnMenu;

/**
 * BibliotecaApp is responsible for launching the Biblioteca Library System.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new LibraryImpl();
        BorrowMenu borrowMenu = new BorrowMenu(library);
        ReturnMenu returnMenu = new ReturnMenu(library);
        MainMenu launch = new MainMenu(library, System.in, System.out, borrowMenu, returnMenu);
        launch.mainMenu();
    }
}