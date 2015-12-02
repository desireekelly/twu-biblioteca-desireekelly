package com.twu.biblioteca;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private boolean status;

    public Book(String title, String author, int yearPublished, boolean status) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = status;
    }

    public Book() {

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

    public boolean getCheckoutStatus() {
        return status;
    }

    public String toString() {
        return this.title + ", " + this.author + ", " + this.yearPublished + ", " + this.status;
    }
}
