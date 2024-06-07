package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class Application {

	public static void main(String[] args) throws FileNotFoundException {


		VariableAssign allVariables = new VariableAssign();


		allVariables.setTotalSales(0.00);
		allVariables.setMachineBalance(0.00);
		allVariables.setOn(true);



		File logFile;
		File salesFile;
		SortedMap<String,List<Item>> vendingMachineItems= new TreeMap<>();
		Scanner keyboard = new Scanner(System.in);



		{
			logFile = new File("src/main/resources/log.txt");
			salesFile = new File("src/main/resources/salesReport");

		}
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






		while (allVariables.isOn()){

			MenuStarter	menu1 = new MenuStarter(keyboard, vendingMachineItems, allVariables, logFile, salesFile);


		}

	}
}
