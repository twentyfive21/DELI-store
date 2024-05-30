package com.pluralsight.menuItems;

public class Drinks extends OrderItem {

    public Drinks(String size, double price, String type) {
        super(size, price, type);
    }

    @Override
    public double getTotal() {
        double total = 0.00;
        if(super.size.equals("Small")){
            total += 2.00;
        } else if(super.size.equals("Medium")){
            total += 2.50;
        } else {
            total += 3.00;
        }
        return total;
    }

    @Override
    public String toString() {
        return type + String.format(" $%,.2f", price) + "\n";
    }
}
