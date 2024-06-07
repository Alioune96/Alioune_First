package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class MenuOrdering {


    public MenuOrdering(VariableAssign allVariables, SortedMap<String, List<Item>> vendingMachinesItems, Scanner keyboard, File logFiles){
        LocalDate dateTime= LocalDate.now();
        LocalTime currentTime = LocalTime.now();
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
                        feedMoney(keyboard, allVariables,writer,dateTime, currentTime);


                    }
                    else if(userParse==2){
                        boughtItems(vendingMachinesItems,boughtItems,keyboard,allVariables,writer,dateTime,currentTime);
                    }

                    else{
                        finishedTransaction(allVariables,writer,dateTime,currentTime);
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

    public void boughtItems(SortedMap <String , List<Item>> vendingMachineItems, List <Item> boughtItems, Scanner keyboard, VariableAssign allVariables, PrintWriter logFile, LocalDate currentDate, LocalTime currentTime){

        String validKey = null;
        while(validKey == null) {

            System.out.println("Would you like to see the menu again?, (Y) or (N)");
            boolean toBeginWith =true;
            while (toBeginWith){
                String confirmation = keyboard.nextLine();
                confirmation.trim().toLowerCase();

                if(confirmation.length()==1) {
                    if (confirmation.contains("y")) {
                        MenuList forPrintAgain = new MenuList(vendingMachineItems);
                        toBeginWith=false;
                    } else if (confirmation.contains("n")){
                        toBeginWith=false;
                    }else {
                        System.out.println("Please try again, letter is invalid.");
                    }
                }
                else {
                    System.out.println("Please try again, input is invalid.");
                }
            }
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

        BigDecimal convertedPrice = new BigDecimal(itemPrice);

        List <Item> itemInfo = vendingMachineItems.get(validKey);

        //machine is larger or equals to converted price
        if(allVariables.getMachineBalance().compareTo(convertedPrice) >= 0){

            if(itemInfo.size() > 1){

                Item customerItem = vendingMachineItems.get(validKey).remove(0);
                String itemName = customerItem.getName();
                boughtItems.add(customerItem);

                allVariables.minusMachineBalance(itemPrice);
                allVariables.addTotalSales(itemPrice);

                logFile.println( currentDate + " " + currentTime + " " + itemName + " " + validKey + " $" + itemPrice + " $" + allVariables.getMachineBalance());

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
                System.out.println("This item is empty");
            }

        }
        else{
            System.out.println("Not Enough money to buy the item. Item cost " + itemPrice);
            System.out.println("You have " + allVariables.getMachineBalance());
        }

    }


    public void feedMoney(Scanner keyboard, VariableAssign allVariables,PrintWriter writer, LocalDate dateTime, LocalTime currentTime){
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
        writer.println(dateTime+" "+ currentTime+" "+ "FEED MONEY: "+ "$"+additionValue +" $"+ allVariables.getMachineBalance());


    }

    public void finishedTransaction(VariableAssign allVariable, PrintWriter writer, LocalDate date,LocalTime time){
        writer.println(date +" "+ time +" "+ "Give Change: "+ "$"+ allVariable.getMachineBalance() + " $0.00");
        System.out.println("Returns your change: " + allVariable.getMachineBalance());
        allVariable.setMachineBalance(0.00);
    }


}
