package com.pluralsight.menuItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem{
    // private attributes
    private List<String> meats;
    private List<String> cheeses;
    private List<String> freeToppings;
    private List<String> freeSauces;

    // constructor

    public Sandwich(String size, double price, String type) {
        super(size, price, type);
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.freeToppings = new ArrayList<>();
        this.freeSauces = new ArrayList<>();
    }


    public List<String> getMeats() {
        return meats;
    }

    public void setMeats(List<String> meats) {
        this.meats = meats;
    }

    public List<String> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<String> cheeses) {
        this.cheeses = cheeses;
    }

    public List<String> getFreeToppings() {
        return freeToppings;
    }

    public void setFreeToppings(List<String> freeToppings) {
        this.freeToppings = freeToppings;
    }

    public List<String> getFreeSauces() {
        return freeSauces;
    }

    public void setFreeSauces(List<String> freeSauces) {
        this.freeSauces = freeSauces;
    }

    @Override
    // abstract method
    public void getTotal(){
        System.out.println("hippo");
    };


    @Override
    public String toString() {
        return "Sandwich{" +
                "size='" + size + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", freeSauces=" + freeSauces +
                ", freeToppings=" + freeToppings +
                ", meats=" + meats +
                ", cheeses=" + cheeses +
                '}';
    }
}
