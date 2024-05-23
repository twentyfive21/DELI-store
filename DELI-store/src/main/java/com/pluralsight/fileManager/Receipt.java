package com.pluralsight.fileManager;

public class Receipt {
   public static void saveOrderToFile(){
       try{
           System.out.println();
       }catch (Exception e){
           System.out.println("Error saving to file");
           e.printStackTrace();
       }
   }
}
