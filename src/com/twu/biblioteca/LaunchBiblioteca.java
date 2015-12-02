package com.twu.biblioteca;

import com.twu.biblioteca.Biblioteca.BibliotecaApp;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;

/**
 * Created by desiree on 2/12/2015.
 */
public class LaunchBiblioteca {
    public static void main(String[] args) {
        BibliotecaApp launch = new BibliotecaApp();
        launch.launchApp();
    }
}
