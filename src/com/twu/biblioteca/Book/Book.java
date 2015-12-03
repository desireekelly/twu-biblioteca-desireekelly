package com.twu.biblioteca.Book;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private int yearPublished;

    public Book(int id, String title, String author, int yearPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getId() {
        return id;
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
        return this.id + ", " + this.title + ", " + this.author + ", " + this.yearPublished;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Book otherBook = (Book) obj;

        return this.id == otherBook.id
                && this.title.equals(otherBook.title)
                && this.author.equals(otherBook.author)
                && this.yearPublished == otherBook.yearPublished;
    }
}