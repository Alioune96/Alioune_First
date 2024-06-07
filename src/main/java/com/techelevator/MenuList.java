package com.techelevator;

import java.util.List;
import java.util.SortedMap;

public class MenuList {

    public MenuList(SortedMap<String, List<Item> >vendingMachineItems) {

        for (String element : vendingMachineItems.keySet()) {

            String key = element;
            String itemName = vendingMachineItems.get(element).get(0).getName();
            double itemPrice = vendingMachineItems.get(element).get(0).getItemCost();

            //has one extra non-existing item for comparision if size == 0
            int itemSize = vendingMachineItems.get(element).size() - 1;

            String outputLine = key + "|" + itemName + "|" + "price: " + itemPrice + "|" + "count: " + itemSize;
            System.out.println(outputLine);
        }
    }
    }


