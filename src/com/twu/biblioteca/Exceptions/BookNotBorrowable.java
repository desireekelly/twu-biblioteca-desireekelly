package com.twu.biblioteca.Exceptions;

/**
 * Created by desiree on 2/12/2015.
 */
public class BookNotBorrowable extends Exception {

    public BookNotBorrowable(String msg){
        super(msg);
    }
}