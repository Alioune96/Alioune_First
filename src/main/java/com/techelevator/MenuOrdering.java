package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuOrdering {


    public void MenuOrdering(int totalSales, double machineBalance, SortedMap<String, List<Item>> vendingMachinesItems, Scanner keyboard, File logFiles){
        try (PrintWriter writer = new PrintWriter(logFiles)){
        } catch (FileNotFoundException e) {
            System.out.println("File is Moved.");
        }
    }

    public void FeedMoney(Scanner keyboard, double machineBalance,PrintWriter writer){
        System.out.println("Please add money to vending machine balance");
        boolean currently = true;
        double additionValue = 0;
        while(currently) {
            try {
                String userInput = keyboard.next();
                additionValue = Double.valueOf(userInput);

                if (additionValue <= 0 && additionValue >= 11) {
                    System.out.println("Vending Machine can't accept amount.");
                } else {
                    machineBalance += additionValue;
                    System.out.println("Current Money Provided: " + machineBalance);

                currently=false;
                }

            } catch (NumberFormatException e) {
                System.out.println("That invalid, Please try again");
            }
        }


        writer.println("FEED MONEY: "+ "$"+additionValue +"$"+ machineBalance);


    }

}
