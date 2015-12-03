package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.MainMenu;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        MainMenu launch = new MainMenu(library);
        launch.mainMenu();
    }
}