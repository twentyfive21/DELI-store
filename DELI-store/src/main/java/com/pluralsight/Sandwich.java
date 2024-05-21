package com.pluralsight;

import java.util.Arrays;

public class Sandwich extends OrderDetails{
    // PRIVATE ATTRIBUTES
    private int size;
    private boolean toasted;
    private String breadType;
    private String premToppings[];
    private String cheeseSlices[];
    private String freeSauces[];
    private String freeToppings[];

    // CONSTRUCTOR
    public Sandwich(Sandwich[] allSandwiches, String[] allChips, String[] allDrinks,
                    int ajuCount, Receipt receipt, String[] freeToppings, String[] freeSauces,
                    String[] cheeseSlices, String[] premToppings, String breadType, boolean toasted, int size) {
        super(allSandwiches, allChips, allDrinks, ajuCount, receipt);
        this.freeToppings = freeToppings;
        this.freeSauces = freeSauces;
        this.cheeseSlices = cheeseSlices;
        this.premToppings = premToppings;
        this.breadType = breadType;
        this.toasted = toasted;
        this.size = size;
    }

    // GETTERS AND SETTERS
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String[] getPremToppings() {
        return premToppings;
    }

    public void setPremToppings(String[] premToppings) {
        this.premToppings = premToppings;
    }

    public String[] getCheeseSlices() {
        return cheeseSlices;
    }

    public void setCheeseSlices(String[] cheeseSlices) {
        this.cheeseSlices = cheeseSlices;
    }

    public String[] getFreeSauces() {
        return freeSauces;
    }

    public void setFreeSauces(String[] freeSauces) {
        this.freeSauces = freeSauces;
    }

    public String[] getFreeToppings() {
        return freeToppings;
    }

    public void setFreeToppings(String[] freeToppings) {
        this.freeToppings = freeToppings;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size=" + size +
                ", toasted=" + toasted +
                ", breadType='" + breadType + '\'' +
                ", premToppings=" + Arrays.toString(premToppings) +
                ", cheeseSlices=" + Arrays.toString(cheeseSlices) +
                ", freeSauces=" + Arrays.toString(freeSauces) +
                ", freeToppings=" + Arrays.toString(freeToppings) +
                '}';
    }
}
