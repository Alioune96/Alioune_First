package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuStarter {

    public MenuStarter(Scanner keyboard, SortedMap<String, List<Item>> vendingMachineItems, VariableAssign allVariables, File logFile, File salesFile){




        Integer numberUserPressed = 0;

        while(numberUserPressed == 0) {
            System.out.println("");
            System.out.println("Menu 1");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            String userInput = keyboard.nextLine();
            userInput = userInput.trim();

            try {
                numberUserPressed = Integer.parseInt(userInput);
                if (numberUserPressed <= 0 || numberUserPressed >= 5) {
                    numberUserPressed = 0;
                }
            } catch (Exception error) {
                System.out.println("Number provided is not a number.");
            }


            if (numberUserPressed == 1) {
                MenuList forPrint= new MenuList(vendingMachineItems);

            } else if (numberUserPressed == 2) {
                MenuOrdering menu2 = new MenuOrdering(allVariables, vendingMachineItems, keyboard, logFile);
            } else if (numberUserPressed == 3) {
                allVariables.setOn(false);
            } else {

                try (PrintWriter writeFile = new PrintWriter(salesFile)) {
                    for (String element : vendingMachineItems.keySet()) {
                        String itemName = vendingMachineItems.get(element).get(0).getName();
                        int itemSize = vendingMachineItems.get(element).size() - 1;

                        writeFile.println(itemName +  "|"  + itemSize);
                        System.out.println(itemName + "|" + itemSize);
                    }
                    System.out.println("");
                    writeFile.println("**TOTAL SALES** " + allVariables.getTotalSales());
                    System.out.println("**TOTAL SALES** " + allVariables.getTotalSales());
                } catch (FileNotFoundException error) {
                    System.out.println("Someone moved the file. Put it back please.");
                }

            }
        }
    }
}
