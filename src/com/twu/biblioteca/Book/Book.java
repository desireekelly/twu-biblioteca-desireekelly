package com.twu.biblioteca.Book;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class Book {

    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String toString() {
        return this.title + ", " + this.author + ", " + this.yearPublished;
    }
}