package com.twu.biblioteca.Utilities;

/**
 * Created by desiree on 5/12/2015.
 */
public class Messages {

    public static String welcomeMessage(){
        String welcomeMessage = "Welcome to the Bangalore Public Library!\n\nWe know you'll find a book here that you love!\n\n";
        return welcomeMessage;
    }

    public static String mainMenuMessage(){
        String mainMenuMessage = "Enter one of the following options:\n" +
              "1 Display the list of available books to borrow\n" +
        "2 Borrow a book\n" +
        "3 Return a book\n" +
        "4 Exit\n";
        return mainMenuMessage;
    }

    public static String optionMessage(){
        String optionMessage = "Enter your option:";
        return optionMessage;
    }

    public static String bookListingMessage(){
        String availableBooksMessage = "\nAvailable Books:\n\n";
        String formattedColumnTitle = String.format("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
        return availableBooksMessage + formattedColumnTitle;
    }

    public static String incorrectInputMessage(){
        String incorrectInputMessage = "\nIncorrect option, please try again.\n\n";
        return incorrectInputMessage;
    }

    public static String incorrectReturnMessage(){
        String incorrectReturnMessage = "\nSorry, there are no available books to return\n\n";
        return incorrectReturnMessage;
    }

    public static String incorrectBorrowMessage(){
        String incorrectBorrowMessage = "\nSorry, there are no available books to borrow\n\n";
        return incorrectBorrowMessage;
    }

    public static String exitMessage() {
        String exitMessage = "\nThank you for using the Bangalore Public Library!\n";
        return exitMessage;
    }

    public static String borrowMessage() {
        String borrowMessage = "\nSelect a book to borrow by entering the ID number or enter 0 to go back to the main menu:\n";
        return borrowMessage;
    }

    public static String borrowThankYouMessage() {
        String borrowThankYouMessage = "\nThank you! Enjoy reading ";
        return borrowThankYouMessage;
    }
}