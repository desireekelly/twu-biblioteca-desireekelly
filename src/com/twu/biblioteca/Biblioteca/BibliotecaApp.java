package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.MainMenu;

/**
 * BibliotecaApp is responsible for launching the Biblioteca Library System.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        MainMenu launch = new MainMenu(library, System.in, System.out);
        launch.mainMenu();
    }
}