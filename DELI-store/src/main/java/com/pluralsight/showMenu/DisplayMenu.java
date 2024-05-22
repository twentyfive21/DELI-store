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

    // **************** START OF PROGRAM ****************

    public static void main(String[] args) {
        displayMenuOptions();
    }


    // **************** DISPLAY THE MAIN MENU ****************
    public static void displayMenuOptions(){
//        Sandwich sandwich = new Sandwich("12'Inch", 8.99, "White Bread");
//        List<String> cheeses = List.of("White", "American");
//        sandwich.setCheeses(cheeses);

        while (true) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|                 🥪 Welcome to Subway! 🥪              |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|  (1) 🥗 Place a New Order                              |");
            System.out.println("|  (2) ❌ Exit                                           |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("|| Please make a selection: ");
            // users choice
            String choice = scan.nextLine().trim();
            switch (choice){
                case "1": System.out.println("place a new order");
                    break;
                case "2": exitProgram();
                    return;
                default: System.out.println("\n!!!! Error pick 1 or 2 !!!!");
                    break;
            }
        }

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
