package com.pluralsight.utilMethods;

public class UtilMethods {

    // **************************** PRINT OUT MENU ARRAY LIST ****************************
    // only for bread type and size
    public static void printOutMenu(String promptMessage, String[] options){
        System.out.println("Choose your "+ promptMessage);
        // display the items available
        for (int i = 0; i < options.length; i++) {
            if(promptMessage.equals("sandwich size:")){
                System.out.printf("|  (%d) %s\"\n", i, options[i]);
            } else {
                System.out.printf("|  (%d) %s\n", i, options[i]);
            }
        }
        System.out.print("|| Please make a selection: ");
    }

    // **************************** PASS ARRAY BACK ****************************

    public static String[] passArray(String type){
        String[] selectedArray = null;

        if(type.equals("bread type")){
            selectedArray = new String[]{"White", "Wheat", "Rye", "Wrap"};
        }

        if (type.equals("bread size")){
            selectedArray = new String[] {"4", "8", "12"};
        }

        if (type.equals("cheese")) {
            selectedArray = new String[] {"American", "Provolone", "Cheddar", "Swiss"};
        }

        if (type.equals("meat")){
            selectedArray = new String[] {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        }

        if (type.equals("free toppings")) {
            selectedArray = new String[]{"Lettuce", "Peppers", "Onions", "Tomatoes",
                    "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
        }

        if(type.equals("sauces")) {
            selectedArray = new String[]{"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
        }

        if(type.equals("chips")) {
            selectedArray = new String[]{"Sun chips", "Lays chips", "Lays Barbeque chips", "Doritos Nacho Cheese chips", "Ruffles Cheddar Chips"};
        }

        if(type.equals("drinks")) {
            selectedArray = new String[]{"Water", "Coke", "Apple juice", "Sprite", "Original Milk tea boba"};
        }

        if(type.equals("drink size")){
            selectedArray = new String[]{"Small", "Medium", "Large"};
        }

        return selectedArray;

    }

}
