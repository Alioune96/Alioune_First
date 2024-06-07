package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuOrdering {


    public MenuOrdering(double totalSales, double machineBalance, SortedMap<String, List<Item>> vendingMachinesItems, Scanner keyboard, File logFiles){
        try (PrintWriter writer = new PrintWriter(logFiles)){
        } catch (FileNotFoundException e) {
            System.out.println("File is Moved.");
        }

        List <Item> boughtItems = new ArrayList<>();


    }

    public void boughtItems(SortedMap <String , List<Item>> vendingMachineItems, List <Item> boughtItems, Scanner keyboard, Double machineBalance, PrintWriter logFile){

        String validKey = null;
        while(validKey == null) {
            System.out.println("Enter a key for an item");
            String userKey = keyboard.nextLine();

            if (vendingMachineItems.containsKey(userKey)) {
                validKey = userKey;
            }
            else {
                System.out.println("Key Value doesn't exist.");
            }
        }

        double itemPrice = vendingMachineItems.get(validKey).get(0).getItemCost();

        if(machineBalance >= itemPrice){

            Item customerItem = vendingMachineItems.get(validKey).remove(0);
            String itemName = customerItem.getName();

            boughtItems.add(customerItem);

            logFile.println(itemName + " " + validKey + " $" + itemPrice + " $" + machineBalance);

            String itemType = customerItem.getTypeOfItem();
            switch(itemType){
                case "Chip":
                    System.out.println("Crunch Crunch, Yum!");
                case "Candy":
                    System.out.println("Munch Munch, Yum!");
                case "Drink":
                    System.out.println( "Glug Glug, Yum!");
                case "Gum":
                    System.out.println("Chew Chew, Yum!");
                default:
            }
        }
        else{
            System.out.println("Not Enough money to buy the item. Item cost " + itemPrice);
            System.out.println("You have " + machineBalance);
        }

    }


    public void feedMoney(Scanner keyboard, double machineBalance,PrintWriter writer){
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
