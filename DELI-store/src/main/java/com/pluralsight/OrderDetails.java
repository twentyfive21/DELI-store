package com.pluralsight;

/*
- Protected members can be accessed by any subclass,
    whether they are in the same package or not.
- Private members, on the other hand, are accessible only within
    the same class. Subclasses cannot directly access private members of their superclass.

- Protected members maintain encapsulation to an extent because
 they are not accessible to any class outside the hierarchy, except through inheritance.

 -
 */

import java.util.Arrays;

public abstract class OrderDetails {
    // protected attributes
   protected Sandwich[] allSandwiches;
   protected String[] allChips;
   protected String[] allDrinks;
   protected int ajuCount;
   protected Receipt receipt;

   // CONSTRUCTOR
   public OrderDetails(Sandwich[] allSandwiches, String[] allChips, String[] allDrinks, int ajuCount, Receipt receipt) {
      this.allSandwiches = allSandwiches;
      this.allChips = allChips;
      this.allDrinks = allDrinks;
      this.ajuCount = ajuCount;
      this.receipt = receipt;
   }

   // GETTERS AND SETTERS

   public Sandwich[] getAllSandwiches() {
      return allSandwiches;
   }

   public void setAllSandwiches(Sandwich[] allSandwiches) {
      this.allSandwiches = allSandwiches;
   }

   public String[] getAllChips() {
      return allChips;
   }

   public void setAllChips(String[] allChips) {
      this.allChips = allChips;
   }

   public String[] getAllDrinks() {
      return allDrinks;
   }

   public void setAllDrinks(String[] allDrinks) {
      this.allDrinks = allDrinks;
   }

   public int getAjuCount() {
      return ajuCount;
   }

   public void setAjuCount(int ajuCount) {
      this.ajuCount = ajuCount;
   }

   public Receipt getReceipt() {
      return receipt;
   }

   public void setReceipt(Receipt receipt) {
      this.receipt = receipt;
   }

   @Override
   public String toString() {
      return "OrderDetails{" +
              "allSandwiches=" + Arrays.toString(allSandwiches) +
              ", allChips=" + Arrays.toString(allChips) +
              ", allDrinks=" + Arrays.toString(allDrinks) +
              ", ajuCount=" + ajuCount +
              ", receipt=" + receipt +
              '}';
   }
}
