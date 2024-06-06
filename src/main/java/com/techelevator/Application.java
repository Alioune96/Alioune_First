package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Application {

	public static void main(String[] args) throws FileNotFoundException {

		double totalSales = 0;
		boolean isOn = true;
		double machineBalance = 0;
		File logFile;
		File salesFile;
		SortedMap<String,List<Item>> vendingMachineItems= new TreeMap<>();



		{
			logFile = new File("C:\\Users\\Student\\workspace\\capstonewithDing\\java-blue-minicapstonemodule1-team3\\src\\main\\resources\\log.txt");
			salesFile = new File("C:\\Users\\Student\\workspace\\capstonewithDing\\java-blue-minicapstonemodule1-team3\\src\\main\\resources\\finalReport.txt");

		}
		Scanner keyboard = new Scanner(System.in);
		File trycase = new File("vendingmachine.csv");
		Scanner readFile = new Scanner(trycase);

		while(readFile.hasNext()){

			String fileinfo = readFile.nextLine();

			List<Item> elevenEachItem = new ArrayList<>();
			String [] splitfileKeys = fileinfo.trim().split("\\|");

			String mapKeys = splitfileKeys[0];
			String itemname = splitfileKeys[1];
			double itemPrice = Double.valueOf(splitfileKeys[2]);
			String itemType = splitfileKeys[3];

			Item chipsTypeOne = new Item(itemname,itemPrice,itemType);

			for (int i = 0; i < 11; i++) {
				elevenEachItem.add(chipsTypeOne);
			}

			vendingMachineItems.put(mapKeys,elevenEachItem);
		}






		while (isOn){
			MenuStarter	menu1 = new MenuStarter(keyboard, vendingMachineItems, isOn, totalSales);
			MenuOrdering menu2 = new MenuOrdering(totalSales, machineBalance, vendingMachineItems, keyboard, logFile);

		}

	}
}
