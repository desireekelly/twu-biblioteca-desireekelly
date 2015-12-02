package com.twu.biblioteca;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaApp {

    public void launchApp(){

        Library library = new Library();
        library.createBookList();
        library.getBookList();
    }
}
