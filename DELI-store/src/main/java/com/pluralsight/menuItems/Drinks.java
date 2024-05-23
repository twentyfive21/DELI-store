package com.pluralsight.menuItems;

public class Drinks extends OrderItem {

    public Drinks(String size, double price, String type) {
        super(size, price, type);
    }

    @Override
    public void getTotal() {

    }

    @Override
    public String toString() {
        return "Drinks{" +
                "size='" + size + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
