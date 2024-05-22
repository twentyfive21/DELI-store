package com.pluralsight.showMenu;

import com.pluralsight.menuItems.Chips;
import com.pluralsight.menuItems.Drinks;
import com.pluralsight.menuItems.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    // keep count of sauce if user adds to order
    public static int aSauce;
    // global scanner
    static Scanner scan = new Scanner(System.in);

    // ***************************** START OF PROGRAM *************************************

    public static void main(String[] args) {
        displayMenuOptions();
    }


    // **************************** DISPLAY THE MAIN MENU ************************************

    public static void displayMenuOptions(){
//        Sandwich sandwich = new Sandwich("12'Inch", 8.99, "White Bread");
//        List<String> cheeses = List.of("White", "American");
//        sandwich.setCheeses(cheeses);

        while (true) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|               🥪 Welcome to Subway! 🥪                |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|  (1) 🥗 Place a New Order                              |");
            System.out.println("|  (2) ❌ Exit                                           |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("|| Please make a selection: ");
            // users choice
            String choice = scan.nextLine().trim();
            switch (choice){
                case "1": displayOrderScreen(); // call the second order screen
                    break;
                case "2": exitProgram(); // exit the program
                    return;
                default: System.out.println("\n❗️️❗️     Error please pick 1 or 2     ❗️❗️"); // handle incorrect input
                    break;
            }
        }

    }

    // **************************** DISPLAY THE ORDER SCREEN ****************************

    public static void displayOrderScreen(){
        while (true){
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
            String choice = scan.nextLine().trim();
            switch (choice){
                case "1": addSandwich();
                    break;
                case "2": addDrink();
                    break;
                case "3": addChips();
                    break;
                case "4": displayCheckout();
                    break;
                case "0": System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Order canceled ~~~~~~~~~~~~~~~~~~~~~");
                    return;
                default: System.out.println("\n️️❗️️️❗️     Error please pick 0 - 4 ️️    ❗️️️❗️"); // handle incorrect input
                    break;
            }
        }
    }

    // **************************** ADD SANDWICH ORDER SCREEN ****************************

    public static void addSandwich(){
        System.out.println("add a sandwich method ");
    }

    // **************************** ADD DRINKS ORDER SCREEN ****************************

    public static void addDrink(){
        System.out.println("add drink method");
    }

    // **************************** ADD CHIPS ORDER SCREEN ****************************

    public static void addChips(){
        System.out.println("add chips method");
    }

    // **************************** DISPLAY CHECKOUT SCREEN ****************************

    public static void displayCheckout(){
        System.out.println("display checkout method");
    }

    // ********************************* EXIT PROGRAM ************************************

    public static void exitProgram(){
        String border = "=========================================================";
        String message = "||   🍅Thank you for visiting! Have a nice day! :) 🧀  ||";

        System.out.println();
        System.out.println(border);
        System.out.println(message);
        System.out.println(border);
    }
}
