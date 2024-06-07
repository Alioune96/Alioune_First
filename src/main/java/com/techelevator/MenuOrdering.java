package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuOrdering {



    public MenuOrdering(VariableAssign allVariables, SortedMap<String, List<Item>> vendingMachinesItems, Scanner keyboard, File logFiles){
        try (PrintWriter writer = new PrintWriter(logFiles)){

            List <Item> boughtItems = new ArrayList<>();



            String userWord = "";
            int userInput = 0;
            while (userInput<3){

                System.out.println("");
                System.out.println("Menu 2");
                System.out.println("(1)Add Money");
                System.out.println("(2)Buy Item");
                System.out.println("(3)Finish Transaction");

                try{
                    userWord = keyboard.nextLine();
                    int userParse = Integer.parseInt(userWord);

                    if(userParse<0 || userParse>3){
                        System.out.println("Wrong input");
                    }
                    else if(userParse==1){
                        feedMoney(keyboard, allVariables,writer);


                    }
                    else if(userParse==2){
                        boughtItems(vendingMachinesItems,boughtItems,keyboard,allVariables,writer);
                    }

                    else{
                        finishedTransaction(allVariables,writer);
                        userInput = 3;
                    }

                }catch (NumberFormatException e){
                    System.out.println("Please enter an valid number");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File is Moved");
        }


    }
]
    public void boughtItems(SortedMap <String , List<Item>> vendingMachineItems, List <Item> boughtItems, Scanner keyboard, VariableAssign allVariables, PrintWriter logFile){


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

        if(allVariables.getMachineBalance() >= itemPrice){

            Item customerItem = vendingMachineItems.get(validKey).remove(0);
            String itemName = customerItem.getName();

            boughtItems.add(customerItem);

            allVariables.minusMachineBalance(itemPrice);
            allVariables.addTotalSales(itemPrice);

            logFile.println(itemName + " " + validKey + " $" + itemPrice + " $" + allVariables.getMachineBalance());

            String itemType = customerItem.getTypeOfItem();
            switch(itemType){
                case "Chip":
                    System.out.println("Crunch Crunch, Yum!");
                    break;
                case "Candy":
                    System.out.println("Munch Munch, Yum!");
                    break;
                case "Drink":
                    System.out.println( "Glug Glug, Yum!");
                    break;
                case "Gum":
                    System.out.println("Chew Chew, Yum!");
                    break;
                default:
            }
            System.out.println("You have " + allVariables.getMachineBalance() + " left.");
        }
        else{
            System.out.println("Not Enough money to buy the item. Item cost " + itemPrice);
            System.out.println("You have " + allVariables.getMachineBalance());
        }

    }


    public void feedMoney(Scanner keyboard, VariableAssign allVariables,PrintWriter writer){
        System.out.println("Please add money to vending machine balance");
        boolean currently = true;
        double additionValue = 0;
        while(currently) {
            try {
                String userInput = keyboard.nextLine();
                additionValue = Double.valueOf(userInput);


                if (additionValue <= 0 || additionValue >= 11) {
                    System.out.println("Vending Machine can't accept amount.");
                } else {
                    allVariables.addMachineBalance(additionValue);
                    System.out.println("Current Money Provided: " + allVariables.getMachineBalance());

                    currently=false;
                }

            } catch (Exception e) {
                System.out.println("That invalid, Please try again");
            }

        }
        writer.println("FEED MONEY: "+ "$"+additionValue +"$"+ allVariables.getMachineBalance());


    }

    public void finishedTransaction(VariableAssign allVariable, PrintWriter writer){
        writer.println("Give Change: "+ "$"+ allVariable.getMachineBalance() + "$0.00");
        System.out.println("Returns your change: " + allVariable.getMachineBalance());
        allVariable.setMachineBalance(0);
    }


}
