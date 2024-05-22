package com.pluralsight.menuItems;
/*
- Protected members can be accessed by any subclass,
    whether they are in the same package or not.
- Private members, on the other hand, are accessible only within
    the same class. Subclasses cannot directly access private members of their superclass.

- Protected members maintain encapsulation to an extent because
 they are not accessible to any class outside the hierarchy, except through inheritance.

 -
 */
public abstract class OrderItem {

    // protected members

    protected String size;
    protected double price;
    protected String type;

    // constructor

    public OrderItem(String size, double price, String type) {
        this.size = size;
        this.price = price;
        this.type = type;
    }


    // getters and setters

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // abstract method
    public abstract void getTotal();

    @Override
    public String toString() {
        return "OrderItem{" +
                "size=" + size +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
