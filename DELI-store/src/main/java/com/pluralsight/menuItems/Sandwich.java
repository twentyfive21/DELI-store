package com.pluralsight.menuItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem{
    // private attributes
    private List<String> meats;
    private List<String> cheeses;
    private List<String> freeToppings;
    private List<String> freeSauces;
    private boolean toasted;

    // constructor

    public Sandwich(String size, double price, String type, boolean toasted) {
        super(size, price, type);
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.freeToppings = new ArrayList<>();
        this.freeSauces = new ArrayList<>();
        this.toasted = toasted;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
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
    public double getTotal(){
    double total = super.price;

        if(super.getSize().equals("4")){

            for(int i = 0; i < meats.size(); i++){
                total += (i == 0) ? 1.00 : .50;
            }

        } else if (super.getSize().equals("8")){

            for(int i = 0; i < meats.size(); i++){
                total += (i == 0) ? 2.00 : 1.00;
            }

        }else {

            for(int i = 0; i < meats.size(); i++){
                total += (i == 0) ? 3.00 : 1.50;
            }

        }

        if(super.getSize().equals("4")){

            for(int i = 0; i < cheeses.size(); i++){
                total += (i == 0) ? 0.75 : 0.30;
            }

        } else if (super.getSize().equals("8")){

            for(int i = 0; i < cheeses.size(); i++){
                total += (i == 0) ? 1.50 : .60;
            }

        }else {

            for(int i = 0; i < cheeses.size(); i++){
                total += (i == 0) ? 2.25 : .90;
            }

        }

        return total;
    };


    @Override
    public String toString() {
        return "\nSandwich size= " + size +
                "\nPrice= " + price +
                "\nType= " + type  +
                "\nFreeSauces = " + freeSauces +
                "\nFree Toppings= " + freeToppings +
                "\nMeats= " + meats +
                "\nCheeses= " + cheeses;
    }
}
