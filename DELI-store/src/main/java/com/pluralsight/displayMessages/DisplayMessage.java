package com.pluralsight.displayMessages;

public class DisplayMessage {

    // ********************************* EXIT PROGRAM ************************************

    public static void displayStartOfProgram(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|               🥪 Welcome to Subway! 🥪                |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (1) 🥗 Place a New Order                              |");
        System.out.println("|  (2) ❌ Exit                                           |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void mainOrderScreen(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|      🛍️ You have selected to start a new order! 🛍️     |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (1) Add a Sandwich 🥖                                 |");
        System.out.println("|  (2) Add a Drink 🥤                                    |");
        System.out.println("|  (3) Add a Chips 🥔                                    |");
        System.out.println("|  (4) Checkout 🛍️                                       |");
        System.out.println("|  (0) Cancel Order ❌                                   |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void exitProgram(){
        String border = "=========================================================";
        String message = "||   🍅Thank you for visiting! Have a nice day! :) 🧀  ||";

        System.out.println();
        System.out.println(border);
        System.out.println(message);
        System.out.println(border);
    }

}
