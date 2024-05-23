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

           for (Sandwich sandwich : allSandwiches){
               bufferedWriter.write(String.valueOf(sandwich));
               bufferedWriter.newLine();
           }

           bufferedWriter.write(allSandwiches.toString());
           bufferedWriter.newLine();
           bufferedWriter.write(allChips.toString());
           bufferedWriter.newLine();
           bufferedWriter.write(allDrinks.toString());
           bufferedWriter.newLine();
           bufferedWriter.write("Total Today: $" + String.format("%,.2f", total));
           bufferedWriter.newLine();
           bufferedWriter.flush();
           bufferedWriter.close();
       }catch (Exception e){
           System.out.println("Error saving to file");
           e.printStackTrace();
       }
   }

}
