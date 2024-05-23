package com.pluralsight.showMenu;
import com.pluralsight.displayMessages.DisplayMessage;
import com.pluralsight.menuItems.Chips;
import com.pluralsight.menuItems.Drinks;
import com.pluralsight.menuItems.OrderItem;
import com.pluralsight.menuItems.Sandwich;
import com.pluralsight.utilMethods.UtilMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    // global scanner
    static Scanner scan = new Scanner(System.in);
    // keep count of sauce if user adds to order
    static int aSauce;
    static List<Sandwich> allSandwiches = new ArrayList<>();
    static List<Chips> allChips = new ArrayList<>();
    static List<Drinks> allDrinks = new ArrayList<>();

    // **************************** DISPLAY THE MAIN MENU ************************************

    public static void display() {
        while (true) {
            // display beginning message & get users choice
            DisplayMessage.displayStartOfProgram();
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "1": displayOrderScreen(); // call the second order screen
                    break;
                case "2": exitProgram(); // exit the program
                    return;
                default: System.out.println("\n❗️️❗️     Error please pick 1 or 2     ❗️❗️");
                    break;
            }
        }

    }

    // **************************** DISPLAY THE ORDER SCREEN ****************************

    public static void displayOrderScreen() {
        while (true) {
            // display main order prompts
            DisplayMessage.mainOrderScreen();
            // get main menu input
            String choice = scan.nextLine().trim();
            switch (choice) {
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
                default: System.out.println("\n️️❗️️️❗️     Error please pick 0 - 4 ️️    ❗️️️❗️");
                    break;
            }
        }
    }

    // **************************** ADD SANDWICH ORDER SCREEN ****************************

    public static void addSandwich() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|       🥖 You have selected to add a Sandwich! 🥖      |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // bread info
        String breadChoice = getSingleItem("bread:", UtilMethods.passArray("bread type"));
        String breadSize = getSingleItem("sandwich size:", UtilMethods.passArray("bread size"));
        double breadSizePrice = getBreadPrice(breadSize);
        // create sandwich object
        Sandwich sandwich = new Sandwich(breadSize, breadSizePrice, breadChoice, getToastedOption());
        // get all toppings & set them in the object
        sandwich.setMeats(getToppings("meat toppings:", UtilMethods.passArray("meat")));
        sandwich.setCheeses(getToppings("cheese toppings:", UtilMethods.passArray("cheese")));
        sandwich.setFreeToppings(getToppings("Regular toppings:", UtilMethods.passArray("free toppings")));
        sandwich.setFreeSauces(getToppings("sauces:", UtilMethods.passArray("sauces")));
        // ask for au jus sauce
        promptASauce();
        allSandwiches.add(sandwich);
    }

    // **************************** GET SANDWICH ORDER SCREEN ****************************

    public static String getSingleItem(String promptMessage, String[] options) {
        while (true) {
    // do not print this for chips or drinks since it is already printed only do for bread type & size
            if(promptMessage.equals("bread:") || promptMessage.equals("sandwich size:")){
                UtilMethods.printOutMenu(promptMessage, options);
            } else if(promptMessage.equals("chips")){
                DisplayMessage.displayChips();
            } else {
                DisplayMessage.displayDrinks();
            }
            String input = scan.nextLine().trim();
            // if int matches array return item
            try {
                // try to parse if string catch shows message
                int choice = Integer.parseInt(input);
                // if it is a number check if in array else display choice not in range
                if (choice >= 0 && choice < options.length) {
                    // return string of selected choice
                    return options[choice];
                } else {
                    // handles error if number given is not in range with the array of items
                    System.out.printf("\n~~~~~ Invalid choice, please enter a number between 0 and " + (options.length - 1) + " ~~~~~\n");
                }
                // handles error if anything but a number is given
            } catch (NumberFormatException e) {
                System.out.println("\n~~~~ Invalid input, please enter a number. ~~~~\n");
            }
        }
    }

// **************************** UTILITY TOPPING ORDER SCREEN ****************************

    public static List<String> getToppings(String promptMessage, String[] options) {
        List<String> selectedToppings = new ArrayList<>();
        boolean moreToppings = true;

        while (moreToppings) {
            System.out.println();
            UtilMethods.printOutMenu(promptMessage, options);
            String input = scan.nextLine().trim();
            // if int matches array return item
            try {
                int choice = Integer.parseInt(input);
                // if it is a number check if in array else display choice not in range
                if (choice >= 0 && choice < options.length) {
                    // return string of selected choice
                    selectedToppings.add(options[choice]);
                    System.out.println("\n**** Added " + options[choice] + " to toppings. ****");
                    // Ask the user if they want to add more toppings
                    System.out.printf("\nWould you like to add more %s? (y) yes or (n) no ", promptMessage);
                    System.out.print("\n|| Selection: ");
                    String addMore = scan.nextLine().toLowerCase().trim();
                    if (addMore.equalsIgnoreCase("n") || addMore.equalsIgnoreCase("no")) {
                        moreToppings = false;
                    }
                } else {
                    // handles error if number given is not in range with the array of items
                    System.out.printf("\n~~~~~ Invalid choice, please enter a number between 0 and " + (options.length - 1) + " ~~~~~\n");
                }
                // handles error if anything but a number is given
            } catch (NumberFormatException e) {
                System.out.println("\n~~~~ Invalid input, please try again ~~~~\n");
            }
        }
        return selectedToppings;
    }

    // **************************** GET TOASTED ORDER SCREEN ****************************

    public static boolean getToastedOption() {
        while (true) {
            System.out.println("Would you like it toasted (y) yes (n) no ? ");
            System.out.print("Choice: ");
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "y": return true;
                case "n": return false;
                default: System.out.println("Invalid choice for toasted");
                    break;
            }
        }
    }

    // **************************** GET BREAD PRICE ORDER SCREEN ****************************

    public static double getBreadPrice(String breadSize) {
        double sizePrice;
        if (breadSize.equals("4")) {
            sizePrice = 5.50;
        } else if (breadSize.equals("8")) {
            sizePrice = 7.00;
        } else {
            sizePrice = 8.50;
        }
        return sizePrice;
    }

// **************************** A SAUCE ORDER SCREEN ****************************

    public static void promptASauce() {
        while (true){
            System.out.println("Would you like au jus sauce? y(yes) or n(no)");
            System.out.print("Selection: ");
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "y": ++aSauce;
                    System.out.println("\n ~~~~ You have selected au jus sauce to be added ~~~~");
                    return;
                case "n": System.out.println("\n ~~~~ You have selected no au jus sauce ~~~~");
                    return;
                default: System.out.println("\n ~~~~ please pick y or n ~~~~");
                    break;
            }
        }

    }

    // **************************** ADD DRINKS ORDER SCREEN ****************************

    public static void addDrink() {
        // super(size, price, type);
        String menuItem = "drinks";
        String chosenDrink = getSingleItem(menuItem, UtilMethods.passArray(menuItem));
        Drinks drink = new Drinks("r", 1.50, chosenDrink);
        allDrinks.add(drink);
    }

    // **************************** ADD CHIPS ORDER SCREEN ****************************

    public static void addChips() {
        String menuItem = "chips";
        String chosenChips = getSingleItem(menuItem, UtilMethods.passArray(menuItem));
        Chips chip = new Chips("r", 1.50, chosenChips);
        allChips.add(chip);
    }

    // **************************** DISPLAY CHECKOUT SCREEN ****************************

    public static void displayCheckout() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|🌸🐷 Currently all the items you ordered are below 🐽🌸 |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // loop this
        for (Sandwich item : allSandwiches){
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|                🥪 Sandwich Details  🥪               |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String isToasted = item.isToasted() ? "toasted" : "not toasted";
            System.out.printf("| Bread type: %s and is %s", item.getType(), isToasted);
            System.out.printf("\n| Bread size: %s\" ", item.getSize());
            System.out.printf("\n| Bread price: $%.2f", item.getPrice());
            System.out.println("\n| Meat Toppings :");
            item.getMeats().forEach(meat -> System.out.println("  - " + meat));
            System.out.println("| Cheese Toppings :");
            item.getCheeses().forEach(cheese -> System.out.println("  - " + cheese));
            System.out.println("| Regular Toppings :");
            item.getFreeToppings().forEach(regTopping -> System.out.println("  - " + regTopping));
            System.out.println("| Sauces :");
            item.getFreeSauces().forEach(sauce -> System.out.println("  - " + sauce));
            System.out.printf("| Au Jus sauce : x %d",aSauce);
        }

        // if there are chips print them
        if(!allChips.isEmpty()){
            DisplayMessage.chipsCheckoutPrompt();
            for(Chips chip : allChips){
                System.out.printf("- %s $%.2f\n", chip.getType(),chip.getPrice());
            }
        }

        // if there are drinks print them
        if(!allDrinks.isEmpty()){
            DisplayMessage.drinkCheckoutPrompt();
            for(Drinks drink : allDrinks){
                System.out.printf("- %s $%.2f\n", drink.getType(),drink.getPrice());
            }
        }

        // display cart checkout options or say there are no items
        if (allDrinks.isEmpty() && allChips.isEmpty() && allSandwiches.isEmpty()){
            DisplayMessage.noItemsInCart();
        } else {
            DisplayMessage.displayCheckout();
        }

    }

    public static void exitProgram() {
        DisplayMessage.exitProgram();
    }
}