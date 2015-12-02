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
        Book b1 = new Book("Java 101", "Joe Bloggs", 1990);
        Book b2 = new Book("PHP 101", "Mary Jane", 2005);
        Book b3 = new Book("C# 101", "John Smith", 2010);
        Book b4 = new Book("C++ 101", "Joyce Merry", 2001);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
    }

    public void displayAvailableBooks() {
        for (Book b : books) {
            if (!borrowedBooks.contains(b)) {
                System.out.println(b);
            }
        }
    }

    public void displayBorrowedBooks(){
        for(Book b: borrowedBooks){
            if (borrowedBooks.contains(b)) {
                System.out.println(b);
            }
        }
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