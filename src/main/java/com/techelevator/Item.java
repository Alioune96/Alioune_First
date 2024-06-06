package com.techelevator;

public class Item {
    String name = "";
    String typeOfItem = "";

    double itemCost = 0;

    public Item(String name,double itemCost, String typeOfItem){
        this.name = name;
        this.typeOfItem = typeOfItem;
        this.itemCost = itemCost;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public double getItemCost() {
        return itemCost;
    }
}
