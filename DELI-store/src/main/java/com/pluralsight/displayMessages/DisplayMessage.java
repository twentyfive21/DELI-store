package com.pluralsight.displayMessages;

public class DisplayMessage {


    public static void displayStartOfProgram(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|            🧀🥬🥪 Welcome to Subway! 🥪🥓🍅           |");
        System.out.println("|           Thank you, for choosing our location!         |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (1) Place a New Order 🍞                              |");
        System.out.println("|  (2) Exit 👋🏼                                           |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void mainOrderScreen(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|      🛍️ You have selected to start a new order! 🛍️     |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (1) Add a custom sandwich 🥖                          |");
        System.out.println("|  (2) Add a signature sandwich 🌟                       |");
        System.out.println("|  (3) Add a Drink 🥤                                    |");
        System.out.println("|  (4) Add a Chips 🥔                                    |");
        System.out.println("|  (5) Checkout 🛍️                                       |");
        System.out.println("|  (6) Go back ↩️                                        |");
        System.out.println("|  (0) Cancel Order ❌                                   |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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

    public static void displayChips(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|          🥔 You have selected to add Chips 🥔          |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (0) Sun chips ☀️                                      |");
        System.out.println("|  (1) Lays chips 🌼                                     |");
        System.out.println("|  (2) Lays Barbeque chips 🍖                            |");
        System.out.println("|  (3) Doritos Nacho Cheese chips 🧀                     |");
        System.out.println("|  (4) Ruffles Cheddar Chips 🧀                          |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void displayDrinks(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|         🥤 You have selected to add a drink  🧃        |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (0) Water 💧                                          |");
        System.out.println("|  (1) Coke 🥤                                           |");
        System.out.println("|  (2) Apple Juice 🧃                                    |");
        System.out.println("|  (3) Sprite 🥤                                         |");
        System.out.println("|  (4) Original Milk tea boba 🧋                         |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void displayCartHeadline(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|🌸🐷 Currently all the items you ordered are below 🐽🌸 |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void displayCheckout(){
        System.out.println("|  (0) Cancel my order");
        System.out.println("|  (1) Confirm and checkout");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void noItemsInCart(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|            🥹 No items ordered currently! 🛒          |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void drinkCheckoutPrompt(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|                    🥤 Drinks 🧋                      |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void chipsCheckoutPrompt(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|                   🥔  Chips  🥔                      |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void displaySandwichesHeadline(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|                🥪 Sandwich Details  🥪               |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void displaySignatureOptions(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|      🥓 You have selected signature sandwiches 🧀      |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|  (1) BLT Sandwich 💧                                   |");
        System.out.println("|  (2) Philly Cheese Steak 🧀                            |");
        System.out.println("|  (3) Go back to order screen 🖥️                        |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }

    public static void displaySignatureModifyChoice(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|       🌭 What else would you like to do today?  🍞     |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| (1) Add sandwich to order 🍽                            |");
        System.out.println("| (2) Change Bread Type 🍞                                |");
        System.out.println("| (3) Add Toppings 🍅                                     |");
        System.out.println("| (4) Remove Toppings 🍴                                  |");
        System.out.println("| (5) Add your modified signature sandwich 🫕             |");
        System.out.println("| (6) Go back ↩️                                          |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("|| Please make a selection: ");
    }



}
