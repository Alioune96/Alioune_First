package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		double totalSales = 0;
		boolean isOn = true;
		double machineBalance = 0;
		File logFile;
		File salesFile;

		{
			logFile = new File("C:\\Users\\Student\\workspace\\capstonewithDing\\java-blue-minicapstonemodule1-team3\\src\\main\\resources\\log.txt");
			salesFile = new File("C:\\Users\\Student\\workspace\\capstonewithDing\\java-blue-minicapstonemodule1-team3\\src\\main\\resources\\finalReport.txt");


		}

		Scanner readFile = new Scanner("vendingmachine.csv");
		String fileinfo = readFile.nextLine();
		String [] splitfileKeys = fileinfo.split("|");

		while (isOn){


		}

	}
}
