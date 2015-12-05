package com.twu.biblioteca.Library;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Exceptions.BookNotBorrowable;
import com.twu.biblioteca.Exceptions.BookNotReturnable;

import java.util.List;

/**
 * Created by desiree on 5/12/2015.
 */
public interface Library {
    /**
     * Get the list of available books.
     *
     * @return Returns a list of books that are available to be borrowed.
     */
    List<Book> getAvailableBooks();

    /**
     * Get the list of borrowed books.
     *
     * @return Returns a list of books that are out for loan.
     */
    List<Book> getBorrowedBooks();

    /**
     * Get the list of all books this library has.
     *
     * @return Returns the book catalog.
     */
    List<Book> getBookList();

    /**
     * Check out a book.
     *
     * @param book The book to check out.
     * @throws BookNotBorrowable Thrown if book is not available to check out.
     */
    void checkoutBook(Book book) throws BookNotBorrowable;

    /**
     * Return a checked out book.
     *
     * @param book The book to return.
     * @throws BookNotReturnable Thrown if book is not currently checked out.
     */
    void returnBook(Book book) throws BookNotReturnable;
}
