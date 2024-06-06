package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuOrdering {


    public MenuOrdering(int totalSales, double machineBalance, SortedMap <String , List<Item>> vendingMachineItems, Scanner keyboard, File logFiles){

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

            Item customerItem = vendingMachineItems.get(validKey).removeLast();
            String itemName = customerItem.getName();

            boughtItems.add(customerItem);



            logFile.println(itemName + " " + validKey + " $" + itemPrice + " $" + machineBalance);

        }
        else{
            System.out.println("Not Enough money to buy the item. Item cost " + itemPrice);
            System.out.println("You have " + machineBalance);
        }

    }


}
