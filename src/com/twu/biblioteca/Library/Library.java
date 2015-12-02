package com.twu.biblioteca.Library;

import com.twu.biblioteca.Book.Book;

import java.util.ArrayList;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class Library extends Book {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
        super();
    }

    public void createBookList(){
        Book b1 = new Book("Java 101", "Joe Bloggs", 1990, true);
        Book b2 = new Book("PHP 101", "Mary Jane", 2005, false);
        Book b3 = new Book("C# 101", "John Smith", 2010, true);
        Book b4 = new Book("C++ 101", "Joyce Merry", 2001, false);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
    }

    public void getBookList(){
        for(Book b: books){
            System.out.println(b);
        }
    }

    public String checkoutBook() {
        return null;
    }

    public String returnBook() {
        return null;
    }
}