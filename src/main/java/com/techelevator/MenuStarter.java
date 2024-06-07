package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuStarter {

    public MenuStarter(Scanner keyboard, SortedMap<String, List<Item>> vendingMachineItems, boolean isOn, double totalSales, double machineBalance, File logFile){


        Integer numberUserPressed = 0;

        while(numberUserPressed == 0){
            System.out.println("Menu 1");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            String userInput = keyboard.nextLine();
            userInput = userInput.trim();

            try{
                numberUserPressed = Integer.parseInt(userInput);
                if(numberUserPressed <= 0 && numberUserPressed >= 5){
                    numberUserPressed = 0;
                }
            }catch(Exception error){
                System.out.println("Number provided is not a number.");
            }
        }

        if(numberUserPressed == 1){
            for(String element: vendingMachineItems.keySet()){

                String key = element;
                String itemName = vendingMachineItems.get(element).get(0).getName();
                double itemPrice = vendingMachineItems.get(element).get(0).getItemCost();
                //has one extra non-existing item for comparision if size == 0
                int itemSize = vendingMachineItems.get(element).size() -1;

                String outputLine = key + "\\|" + itemName + "\\|" + "price: " + itemPrice + "\\|" + "count: " + itemSize;
                System.out.println(outputLine);
            }
        }
        else if(numberUserPressed == 2){
            MenuOrdering menu2 = new MenuOrdering(totalSales, machineBalance, vendingMachineItems, keyboard, logFile);
        }
        else if(numberUserPressed == 3){
            isOn = false;
        }
        else{
            File salesReport = new File("C:\\Users\\Student\\workspace\\pairs\\capstoneModule1\\java-blue-minicapstonemodule1-team3\\src\\main\\resources\\salesReport");

            try(PrintWriter writeFile = new PrintWriter(salesReport)){
                for(String element: vendingMachineItems.keySet()){
                    String itemName = vendingMachineItems.get(element).get(0).getName();
                    int itemSize = vendingMachineItems.get(element).size() - 1;
                    System.out.println(itemName + "\\|" + itemSize);
                }
                System.out.println("");
                System.out.println("**TOTAL SALES** " + totalSales);
            }
            catch(FileNotFoundException error){
                System.out.println("Someone moved the file. Put it back please.");
            }

        }
    }
}
