package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book.Book;
import java.util.List;

/**
 * Created by Desiree Kelly on 3/12/2015.
 */
public class Utilities {

    public static String displayFormattedBookList(List<Book> availableBooks){
        String formattedBookList = "";
        int index = 0;

        for(Book b: availableBooks) {
            index++;
            formattedBookList += String.format("%-15s %-15s %-15s %-15s\n", index, b.getTitle(), b.getAuthor(), b.getYearPublished());
        }
        return formattedBookList;
    }
}