package com.pluralsight.showMenu;
import com.pluralsight.displayMessages.DisplayMessage;
import com.pluralsight.fileManager.Receipt;
import com.pluralsight.menuItems.*;
import com.pluralsight.utilMethods.UtilMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {

    // global scanner
    static Scanner scan = new Scanner(System.in);
    // keep count of sauce if user adds to order
    static String signatureChoice = "blt";
    static List<Sandwich> allSandwiches = new ArrayList<>();
    static List<Chips> allChips = new ArrayList<>();
    static List<Drinks> allDrinks = new ArrayList<>();
    static Sandwich bltSandwich = new Sandwich("8", 7.00, "White",true,0);
    static Sandwich phillySandwich = new Sandwich("8",7.00,"White",true,0);

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

    // **************************** LOAD SIGNATURE SANDWICHES  ************************************

    public static void loadSignatureSandwiches(){
        List<String> bltMeats = new ArrayList<>(List.of("Bacon"));
        List<String> bltCheeses = new ArrayList<>(List.of("Cheddar"));
        List<String> bltRegToppings = new ArrayList<>(Arrays.asList("Lettuce", "Tomato"));
        List<String> bltSauces = new ArrayList<>(List.of("Ranch"));
        bltSandwich.setMeats(bltMeats);
        bltSandwich.setCheeses(bltCheeses);
        bltSandwich.setFreeToppings(bltRegToppings);
        bltSandwich.setFreeSauces(bltSauces);


        List<String> philMeats = new ArrayList<>(List.of("Steak"));
        List<String> philCheeses = new ArrayList<>(List.of("American Cheese"));
        List<String> philRegToppings = new ArrayList<>(List.of("Peppers"));
        List<String> philSauces = new ArrayList<>(List.of("Mayo"));
        phillySandwich.setMeats(philMeats);
        phillySandwich.setCheeses(philCheeses);
        phillySandwich.setFreeToppings(philRegToppings);
        phillySandwich.setFreeSauces(philSauces);

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
                case "2": addSignatureSandwich();
                    break;
                case "3": addDrink();
                    break;
                case "4": addChips();
                    break;
                case "5": displayCheckout();
                    break;
                case "6": return; // go back to main screen
                case "0": cancelOrder();
                    return;
                default: System.out.println("\n️️❗️️️❗️     Error please pick 0 - 4 ️️    ❗️️️❗️");
                    break;
            }
        }
    }

    // **************************** CANCEL ORDER AND CLEAR ARRAYS ************************************

    public static void cancelOrder(){
        allSandwiches.clear();
        allChips.clear();
        allDrinks.clear();
    }

    // **************************** ADD SIGNATURE SANDWICH ORDER SCREEN ****************************

    public static void addSignatureSandwich(){
        while (true){
            DisplayMessage.displaySignatureOptions();
            String choice = scan.nextLine().trim();
            switch (choice){
                case "1": modifySignatureSandwich(bltSandwich);
                    signatureChoice = "blt";
                    break;
                case "2":modifySignatureSandwich(phillySandwich);
                    signatureChoice = "philly";
                    break;
                case "3": return;
                default: System.out.println("\n**** Invalid signature choice please select 1-3 ****");
                    break;
            }
        }
    }

    // **************************** MODIFY SIGNATURE SANDWICH ORDER SCREEN ****************************

    public static void modifySignatureSandwich(Sandwich sandwich) {
        while (true) {
            DisplayMessage.displaySandwichesHeadline();

            // display what the current sandwich contains

            String toasted = sandwich.isToasted() ? "is toasted" : "not toasted";
            System.out.printf("Bread type: %s and %s\n", sandwich.getType(), toasted);
            System.out.printf("Bread size: %s' \n", sandwich.getSize());

            // display meats
            System.out.println("Meat Toppings: ");
            for (String meatTopping : sandwich.getMeats()){
                System.out.println("  - " + meatTopping);
            }

            // display cheeses
            System.out.println("Cheese Toppings: ");
            for (String cheeseTopping : sandwich.getCheeses()){
                System.out.println("  - " + cheeseTopping);
            }

            // display regular toppings
            System.out.println("Regular Toppings: ");
            for (String freeTopping : sandwich.getFreeToppings()){
                System.out.println("  - " + freeTopping);
            }

            // display the sauces
            System.out.println("Sauces: ");
            for (String sauces : sandwich.getFreeSauces()){
                System.out.println("  - " + sauces);
            }

            // set which signature sandwich was chosen
            Sandwich modifiedsandwich;
            if(signatureChoice.equals("blt")){
                modifiedsandwich = bltSandwich;
            } else {
                modifiedsandwich = phillySandwich;
            }
            DisplayMessage.displaySignatureModifyChoice();

            // get users choice for signature
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "1": // Confirm order without changes
                    allSandwiches.add(sandwich);
                    return;
                case "2": // Change bread type
                    changeBreadType(sandwich);
                    break;
                case "3": // Add toppings
                    addToppings(sandwich);
                    break;
                case "4": // Delete toppings
                    deleteToppings(sandwich);
                    break;
                case "5": allSandwiches.add(modifiedsandwich);
                    return;
                case "6": // Exit modification
                    return;
                default:
                    System.out.println("\n**** Invalid choice, please select 1-6 ****");
                    break;
            }
        }
    }

    // ****************************    MODIFY BREAD TYPE     ****************************

    public static void changeBreadType(Sandwich sandwich) {
        String newBreadType = getSingleItem("bread:", UtilMethods.passArray("bread type"));
        sandwich.setType(newBreadType);
        System.out.println("Bread type changed to " + newBreadType);

    }

    // ****************************    ADD TOPPINGS FOR SIGNATURE SANDWICH     ****************************

    public static void addToppings(Sandwich sandwich) {
        System.out.println("What type of toppings would you like to add? or select 4 to exit");
        String[] toppingTypes = {"Meat", "Cheese", "Free Toppings", "Sauces", "Exit"};
        UtilMethods.printOutMenu("Topping types:", toppingTypes);
        String choice = scan.nextLine().trim();
        switch (choice) {
            case "0":
                // .add(type) is a method in the class to add item to arraylist
                sandwich.addMeats(getToppings("meat toppings:", UtilMethods.passArray("meat")));
                break;
            case "1":
                sandwich.addCheeses(getToppings("cheese toppings:", UtilMethods.passArray("cheese")));
                break;
            case "2":
                sandwich.addFreeToppings(getToppings("regular toppings:", UtilMethods.passArray("free toppings")));
                break;
            case "3":
                sandwich.addFreeSauces(getToppings("sauces:", UtilMethods.passArray("sauces")));
                break;
            case "4": return;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    // ****************************     DELETE TOPPINGS FOR SIGNATURE SANDWICH    ****************************

    public static void deleteToppings(Sandwich sandwich) {
    //  .toArray(new String[0]): This part converts the list of meat toppings to an array of strings.
    //    - toArray() is a method that converts a list to an array.
    //    - new String[0] creates a new empty array of strings.
    //    - This method call ensures that the toArray() method creates a new array of the correct type to hold the elements.
        System.out.println("What type of toppings would you like to delete? or select 4 to exit");
        String[] toppingTypes = {"Meat", "Cheese", "Free Toppings", "Sauces", "Exit"};
        UtilMethods.printOutMenu("Topping types:", toppingTypes);
        String choice = scan.nextLine().trim();
        switch (choice) {
            case "0":
                sandwich.removeMeats(getToppings("meat toppings to remove:", sandwich.getMeats().toArray(new String[0])));
                break;
            case "1":
                sandwich.removeCheeses(getToppings("cheese toppings to remove:", sandwich.getCheeses().toArray(new String[0])));
                break;
            case "2":
                sandwich.removeFreeToppings(getToppings("regular toppings to remove:", sandwich.getFreeToppings().toArray(new String[0])));
                break;
            case "3":
                sandwich.removeFreeSauces(getToppings("sauces to remove:", sandwich.getFreeSauces().toArray(new String[0])));
                break;
            case "4": return;
            default:
                System.out.println("Invalid choice");
                break;
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
        Sandwich sandwich = new Sandwich(breadSize, breadSizePrice, breadChoice, getToastedOption(), 0);
        // get all toppings & set them in the object
        sandwich.setMeats(getToppings("meat toppings:", UtilMethods.passArray("meat")));
        sandwich.setCheeses(getToppings("cheese toppings:", UtilMethods.passArray("cheese")));
        sandwich.setFreeToppings(getToppings("Regular toppings:", UtilMethods.passArray("free toppings")));
        sandwich.setFreeSauces(getToppings("sauces:", UtilMethods.passArray("sauces")));
        // ask for au jus sauce
        promptASauce(sandwich);
        allSandwiches.add(sandwich);
    }

    // **************************** GET SANDWICH ORDER SCREEN ****************************

    public static String getSingleItem(String promptMessage, String[] options) {
     while (true) {
    // do not print this for chips or drinks since it is already printed only do for bread type & size
     if(promptMessage.equals("bread:") || promptMessage.equals("sandwich size:") || promptMessage.equals("drink size")){
                UtilMethods.printOutMenu(promptMessage, options);
            } else if(promptMessage.equals("chips")){
                DisplayMessage.displayChips();
            } else {
                // drink type
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
        // init arraylist
        List<String> selectedToppings = new ArrayList<>();
        boolean moreToppings = true;
        // keep adding toppings till false
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

                    if(promptMessage.contains("remove")){
                        System.out.println("\n**** Item " + options[choice] + " removed from toppings. ****");
                    } else {
                        System.out.println("\n**** Added " + options[choice] + " to toppings. ****");
                    }

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

    public static void promptASauce(Sandwich sandwich) {
        while (true){
            System.out.println("Would you like au jus sauce? y(yes) or n(no)");
            System.out.print("Selection: ");
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "y": sandwich.setaSauce(1);
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
        String menuSize = "drink size";
        double drinkPrice;
        String chosenDrink = getSingleItem(menuItem, UtilMethods.passArray(menuItem));
        String drinkSize = getSingleItem(menuSize, UtilMethods.passArray(menuSize));
        // set drink price
        if(drinkSize.equals("Small")){
            drinkPrice = 2.00;
        } else if (drinkSize.equals("Medium")){
            drinkPrice = 2.50;
        }else {
            drinkPrice = 3.00;
        }
        // create drink object and add to arraylist
        Drinks drink = new Drinks(drinkSize, drinkPrice, chosenDrink);
        allDrinks.add(drink);
    }

    // **************************** ADD CHIPS ORDER SCREEN ****************************

    public static void addChips() {
        String menuItem = "chips";
        String chosenChips = getSingleItem(menuItem, UtilMethods.passArray(menuItem));
        // create chip object and add to arraylist
        Chips chip = new Chips("r", 1.50, chosenChips);
        allChips.add(chip);
    }

    // **************************** DISPLAY CHECKOUT SCREEN ****************************

    public static void displayCheckout() {
        while (true) {
            // initialize total
            double total = 0.00;
            DisplayMessage.displayCartHeadline();

            // if there are sandwiches display each one
            for (Sandwich item : allSandwiches) {

                // show headline and get bread data
                DisplayMessage.displaySandwichesHeadline();
                String isToasted = item.isToasted() ? "toasted" : "not toasted";
                System.out.printf("| Bread type: %s %s' & is %s", item.getType(), item.getSize(), isToasted);
                System.out.printf("\n| Bread price: $%.2f", item.getPrice());

                // dispaly all toppings
                System.out.println("\n| Meat Toppings :");
                item.getMeats().forEach(meat -> System.out.println("  - " + meat));
                System.out.println("| Cheese Toppings :");
                item.getCheeses().forEach(cheese -> System.out.println("  - " + cheese));
                System.out.println("| Regular Toppings :");
                item.getFreeToppings().forEach(regTopping -> System.out.println("  - " + regTopping));
                System.out.println("| Sauces :");
                item.getFreeSauces().forEach(sauce -> System.out.println("  - " + sauce));

                /// if au jus sauce added display it
                if(item.getaSauce() > 0 ){
                    System.out.printf("| Au Jus sauce : x %d", item.getaSauce());
                }

                // calculate total of all ingredients
                total += item.getTotal();
            }

            // if there are chips print them
            if (!allChips.isEmpty()) {
                DisplayMessage.chipsCheckoutPrompt();
                for (Chips chip : allChips) {
                    System.out.printf("- %s $%.2f\n", chip.getType(), chip.getPrice());
                   total += chip.getPrice();
                }
            }

            // if there are drinks print them
            if (!allDrinks.isEmpty()) {
                DisplayMessage.drinkCheckoutPrompt();
                for (Drinks drink : allDrinks) {
                    System.out.printf("- %s $%.2f\n", drink.getType(), drink.getPrice());
                    total += drink.getPrice();
                }
            }

            // display cart checkout options or say there are no items
            if (allDrinks.isEmpty() && allChips.isEmpty() && allSandwiches.isEmpty()) {
                DisplayMessage.noItemsInCart();

                // !!! if cart is empty return to menu after displaying no items !!!
                return;

            } else {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.printf("|  💰 Order Total: $%.2f\n", total);
                DisplayMessage.displayCheckout();
            }

            // ask user if they want to purchase the item or delete it
            String choice = scan.nextLine();
            switch (choice){
                case "0" : cancelOrder(); // clear out the order & go back home
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Order canceled ~~~~~~~~~~~~~~~~~~~~~");
                    return;
                case "1": Receipt.saveOrderToFile(total,allSandwiches,allDrinks,allChips); // save to csv
                    System.out.println("\n 🥳 Thank you for your payment! Here is your order 🥳");
                    cancelOrder();  // clear old order
                    return;
                default: System.out.println("\n**** Error please pick 1 or 2 ****");
                    break;

            }
        }
    }

    // ****************************** EXIT PROGRAM *****************************************

    public static void exitProgram() {
        DisplayMessage.exitProgram();
    }

}