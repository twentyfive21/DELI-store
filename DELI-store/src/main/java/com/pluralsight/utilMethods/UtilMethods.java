package com.pluralsight.utilMethods;

public class UtilMethods {

    // **************************** PRINT OUT MENU ARRAY LIST ****************************
    public static void printOutMenu(String promptMessage, String[] options){
        System.out.println("Choose your "+ promptMessage);
        // display the items available
        for (int i = 0; i < options.length; i++) {
            System.out.printf("|  (%d) %s\n", i, options[i]);
        }
        // let user pick their selection
        System.out.print("|| Selection: ");
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

        return selectedArray;

    }

}
