package com.twu.biblioteca.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by desiree on 5/12/2015.
 */
public class Messages {

    public static String WelcomeMessage(){
        String welcomeMessage = "Welcome to the Bangalore Public Library!\nWe know you'll find a book here that you love!\n";

        return welcomeMessage;
    }

    public static String MainMenuMessages(){
        String mainMenuMessages = "\nEnter one of the following options:\n" +
              "1 Display the list of available books to borrow\n" +
        "2 Borrow a book\n" +
        "3 Return a book\n" +
        "4 Exit\n" +
        "Enter your option:";

        return mainMenuMessages;
    }




}
