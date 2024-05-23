package com.pluralsight.menuItems;

public class Chips extends OrderItem{

    public Chips(String size, double price, String type) {
        super(size, price, type);
    }

    @Override
    public void getTotal() {

    }

    @Override
    public String toString() {
        return "Chips{" +
                "size='" + size + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
