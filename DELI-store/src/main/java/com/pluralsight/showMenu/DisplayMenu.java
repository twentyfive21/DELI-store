package com.pluralsight.showMenu;
import com.pluralsight.displayMessages.DisplayMessage;
import com.pluralsight.menuItems.Sandwich;
import com.pluralsight.utilMethods.UtilMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    // keep count of sauce if user adds to order
    public static int aSauce;
    // global scanner
    static Scanner scan = new Scanner(System.in);

    // **************************** DISPLAY THE MAIN MENU ************************************

    public static void displayMenuOptions() {
        while (true) {
            // display beginning message
            DisplayMessage.displayStartOfProgram();
            // users choice
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "1":
                    displayOrderScreen(); // call the second order screen
                    break;
                case "2":
                    exitProgram(); // exit the program
                    return;
                default:
                    System.out.println("\n❗️️❗️     Error please pick 1 or 2     ❗️❗️"); // handle incorrect input
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
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    displayCheckout();
                    break;
                case "0":
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Order canceled ~~~~~~~~~~~~~~~~~~~~~");
                    return;
                default:
                    System.out.println("\n️️❗️️️❗️     Error please pick 0 - 4 ️️    ❗️️️❗️"); // handle incorrect input
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
        String breadChoice = getSandwichPrompts("bread:", UtilMethods.passArray("bread type"));
        String breadSize = getSandwichPrompts("sandwich size:", UtilMethods.passArray("bread size"));
        double breadSizePrice = getBreadPrice(breadSize);

        // get all toppings
        List<String> meats = getToppings("meat toppings:", UtilMethods.passArray("meat"));
        List<String> cheeseChoice = getToppings("cheese toppings:", UtilMethods.passArray("cheese"));
        List<String> freeToppings = getToppings("Regular toppings:", UtilMethods.passArray("free toppings"));
        List<String> freeSauces = getToppings("sauces:", UtilMethods.passArray("sauces"));
        boolean toasted = getToastedOption();
        Sandwich sandwich = new Sandwich(breadSize, breadSizePrice, breadChoice, toasted);
        // ask for au jus sauce
        promptASauce();
        System.out.println(sandwich);
    }


    // **************************** GET SANDWICH ORDER SCREEN ****************************

    public static String getSandwichPrompts(String promptMessage, String[] options) {

        while (true) {
            UtilMethods.printOutMenu(promptMessage, options);
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
            UtilMethods.printOutMenu(promptMessage, options);
            String input = scan.nextLine().trim();
            // if int matches array return item
            try {
                int choice = Integer.parseInt(input);
                // if it is a number check if in array else display choice not in range
                if (choice >= 0 && choice < options.length) {
                    // return string of selected choice
                    selectedToppings.add(options[choice]);
                    System.out.println("Added " + options[choice] + " to toppings.");
                    // Ask the user if they want to add more toppings
                    System.out.printf("\nWould you like to add more %s? (y) yes or (n) no ", promptMessage);
                    System.out.print("|| Selection: ");
                    String addMore = scan.nextLine().toLowerCase().trim();
                    if (addMore.equals("n")) {
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
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Invalid choice for toasted");
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
        System.out.println("Would you like au jus sauce? y(yes) or n(no)");
        System.out.print("Selection: ");
        String choice = scan.nextLine().trim();
        switch (choice) {
            case "y":
                ++aSauce;
                System.out.println("\n ~~~~ You have selected au jus sauce to be added ~~~~");
                break;
            case "n":
                System.out.println("\n ~~~~ You have selected no au jus sauce ~~~~");
                break;
            default:
                System.out.println("\n ~~~~ please pick y or n ~~~~");
        }
    }

    // **************************** ADD DRINKS ORDER SCREEN ****************************

    public static void addDrink() {
        System.out.println("add drink method");
    }

    // **************************** ADD CHIPS ORDER SCREEN ****************************

    public static void addChips() {
        System.out.println("add chips method");
    }

    // **************************** DISPLAY CHECKOUT SCREEN ****************************

    public static void displayCheckout() {
        System.out.println("display checkout method");
    }

    public static void exitProgram() {
        DisplayMessage.exitProgram();
    }
}