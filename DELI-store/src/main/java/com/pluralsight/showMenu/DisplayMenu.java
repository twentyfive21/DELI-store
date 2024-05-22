package com.pluralsight.showMenu;

import com.pluralsight.menuItems.Chips;
import com.pluralsight.menuItems.Drinks;
import com.pluralsight.menuItems.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class DisplayMenu {
    // keep count of sauce if user adds to order
    public int aSauce;

    // **************** START OF PROGRAM ****************

    public static void main(String[] args) {
        displayMenuOptions();
    }
    // **************** DISPLAY THE MAIN MENU ****************
    public static void displayMenuOptions(){
        Sandwich sandwich = new Sandwich("12'Inch", 8.99, "White Bread");
        List<String> cheeses = List.of("White", "American");
        sandwich.setCheeses(cheeses);
        List<String> meats = List.of("Steak", "Chicken");
        sandwich.setMeats(meats);
        List<String> toppings = List.of("lettuce", "onions");
        sandwich.setFreeToppings(toppings);
        System.out.println(sandwich);

        Chips chips = new Chips("Snack Size", 1.25, "Takis");

        System.out.println(chips);

        Drinks drinks = new Drinks("XXL", 6.78, "Big Boke!");

        System.out.println(drinks);
    }
}
