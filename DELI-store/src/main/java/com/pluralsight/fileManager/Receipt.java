package com.pluralsight.fileManager;

import com.pluralsight.menuItems.Chips;
import com.pluralsight.menuItems.Drinks;
import com.pluralsight.menuItems.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt {

   public static void saveOrderToFile(double total, List<Sandwich> allSandwiches, List<Drinks> allDrinks, List<Chips> allChips){
       try{ // yyyyMMdd-hhmmss.txt
           // Get the current date and time
           LocalDateTime now = LocalDateTime.now();
           // Define the pattern
           // single quotes around .txt indicate that .txt is a literal string and should be included exactly as is
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss'.txt'");
           // Format the date and time
           String formattedDate = now.format(formatter);
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(formattedDate));
           bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           bufferedWriter.write("|                        Receipt                         |\n");
           bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

           // ***********************  write sandwiches to file **************************

           if(allSandwiches.isEmpty()){
               bufferedWriter.write("| No sandwiches ordered \n");
               bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           } else {
               bufferedWriter.write("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
               bufferedWriter.write("|                 🥪 Sandwich Details  🥪               |\n");
               bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
               for (Sandwich sandwich : allSandwiches){
                   bufferedWriter.write(String.valueOf(sandwich));
                   if(allSandwiches.size() > 1){
                       bufferedWriter.write("\n---------------------------------------------------");
                   }
                   bufferedWriter.newLine();
               }
           }
           bufferedWriter.write("*********************************************************\n");
           // ***********************  write chips to file **************************

          if (allChips.isEmpty()){
              bufferedWriter.write("| No chips ordered\n");
              bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
          } else {
              bufferedWriter.write("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
              bufferedWriter.write("|                     🥔  Chips  🥔                     |\n");
              bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
              for (Chips chip: allChips){
                  bufferedWriter.write(String.valueOf(chip));
              }
          }
           bufferedWriter.write("*********************************************************\n");

           // ***********************  drinks to file **************************

          if (allDrinks.isEmpty()){
              bufferedWriter.write("| No drinks ordered \n");
              bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
          }else {
              bufferedWriter.write("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
              bufferedWriter.write("|                      🥤 Drinks 🧋                     |\n");
              bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
              for (Drinks drink : allDrinks){
                  bufferedWriter.write(String.valueOf(drink));
              }
          }
           bufferedWriter.write("*********************************************************\n");
           // ***********************  write total and close writer **************************
           bufferedWriter.write("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           bufferedWriter.write("Total Today: $" + String.format("%,.2f", total));
           bufferedWriter.write("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
           bufferedWriter.flush();
           bufferedWriter.close();
       }catch (Exception e){
           System.out.println("Error saving to file");
           e.printStackTrace();
       }
   }

}
