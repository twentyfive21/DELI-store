package com.pluralsight.menuItems;

public class Chips extends OrderItem{

    public Chips(String size, double price, String type) {
        super(size, price, type);
    }



    @Override
    public double getTotal() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "\nChips Details: " +
                "\nPrice= " + price +
                "\nType= " + type;
    }
}
