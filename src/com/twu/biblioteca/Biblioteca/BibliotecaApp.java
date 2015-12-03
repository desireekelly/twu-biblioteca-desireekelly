package com.twu.biblioteca.Biblioteca;

import com.twu.biblioteca.Book.Book;
import com.twu.biblioteca.Library.Library;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Desiree Kelly on 2/12/2015.
 */
public class BibliotecaApp {

    private Library library;
    private Scanner input;
    private int option;

    public BibliotecaApp(){
        library = new Library();
        input = new Scanner(System.in);
    }

    public void launchApp() {
        System.out.println("Welcome to the Bangalore Public Library!\n");
        System.out.println("We know you'll find a book here that you love!\n");

        mainMenu();
        /*
        System.out.println("Available Books:");
        library.displayAvailableBooks();

        try {
            library.checkoutBook(library.getBookList().get(0));
        }catch(BookNotBorrowable e){
            System.out.println("\n" + e.getMessage());
        }

        System.out.println("\nBorrowed Books:");
        library.displayBorrowedBooks();

        try {
            library.returnBook(library.getBookList().get(0));
        }catch(BookNotReturnable e){
            System.out.println("\n" + e.getMessage());
        }
        */
    }

    public void mainMenu(){
        while(true) {
            try {
                System.out.print("Enter one of the following options:\n" +
                        "1 Display the list of available books to borrow\n" +
                        "2 Borrow a book\n" +
                        "3 Return a book\n" +
                        "4 Exit\n" +
                        "Enter your option:");
                option = input.nextInt();
            }
            catch(InputMismatchException e){
                input.nextLine();
            }
            menuOptions(option);
        }
    }

    public String displayFormattedStrings(String availableBooks){
        String [] books = availableBooks.split("\\r?\\n");
        String formattedBooks = "";

        for(String b: books) {
            String[] token = b.split(", ");
            formattedBooks += String.format("%-15s %-15s %-15s %-15s\n", token[0], token[1], token[2], token[3]);
        }
     return formattedBooks;
    }

    private String bookListToString(List<Book> books) {
        StringBuffer buff = new StringBuffer();
        for (Book b : books) {
            buff.append(b);
        }
        return buff.toString();
    }

    public void menuOptions(int option){
        switch(option) {
            case 1:
                System.out.print("\n");
                System.out.println("Available Books: \n");
                System.out.printf("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
                System.out.println(displayFormattedStrings(bookListToString(library.getAvailableBooks())));
                break;
            case 2:
                System.out.print("\n");
                System.out.println("Borrow book process\n");
                //System.out.println("Select a book to borrow by entering the ID number:\n");
                break;
            case 3:
                System.out.print("\n");
                System.out.println("Return book process\n");
                break;
            case 4:
                System.out.println("\nThank you for using the Bangalore Public Library!");
                System.exit(0);
            default:
                System.out.println("\nIncorrect option, please try again.\n");
        }
    }
}