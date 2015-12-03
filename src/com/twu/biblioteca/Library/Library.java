package com.twu.biblioteca.Library;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;

import java.util.*;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class Library {

    private List<Book> books = new ArrayList<Book>();
    private Set<Book> borrowedBooks = new HashSet<Book>();

    public Library() {
        this.createBookList();
    }

    private void createBookList(){
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        books.add(new Book("C# 101", "John Smith", 2010));
        books.add(new Book("C++ 101", "Joyce Merry", 2001));
    }

    public List<Book> getAvailableBooks() {
        List<Book> results = new ArrayList<Book>(books.size());
        for(Book b : books) {
            if(!borrowedBooks.contains(b)) {
                results.add(b);
            }
        }
        return results;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> results = new ArrayList<Book>(books.size());
        for(Book b : books) {
            if(borrowedBooks.contains(b)) {
                results.add(b);
            }
        }
        return results;
    }

    public List<Book> getBookList() {
        return Collections.unmodifiableList(books);
    }

    public void checkoutBook(Book book) throws BookNotBorrowable {
        if (borrowedBooks.contains(book))
            throw new BookNotBorrowable("Book is not available");
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) throws BookNotReturnable {
        if (!borrowedBooks.contains(book))
            throw new BookNotReturnable("Book is already returned");
        borrowedBooks.remove(book);
    }
}