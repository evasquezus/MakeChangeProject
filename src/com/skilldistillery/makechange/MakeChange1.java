package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange1 {
	int dollar = 0, five  = 0, ten  = 0, twenty  = 0;
	int pennie = 0, dime = 0, quarter = 0, nickle = 0;

	public double doCalculation(double price, double moneyTendered) {
		//conversion to pennies
		int costInPennies = (int) price * 100;
		int change = (int) (moneyTendered - costInPennies);

		if (change >= 2000) {
			twenty = change / 2000;
			change = change % 2000;
			System.out.println(twenty + " twentyDollar bills");
		}
		if (change >= 1000) {
			ten = change / 1000;
			change = change % 1000;
			System.out.println(ten + " ten dollar bills");
		}
		if (change >= 500) {
			five = change / 500;
			change = change % 500;
			System.out.println(five + " five dollar bills");
		}
		if (change >= 100) {
			dollar = change / 100;
			change = change % 100;
			System.out.println(dollar + " one dollar bills");
		}
		if (change >= 25) {
			quarter = change / 25;
			change = change % 25;
			System.out.println(quarter + " quarters");
		}
		if (change >= 10) {
			dime = change / 10;
			change = change % 10;
			System.out.println(dime + " dimes");
		}
		if (change >= 5) {
			nickle = change / 5;
			change = change % 5;
			System.out.println(nickle + " nickles");
		}
		if (change >= 1) {
			pennie = change / 1;
			change = change % 1;
			System.out.println(pennie + " pennies");
		}

		return change;

	}
	
	public void initialPrompt() {
		Scanner keyboard = new Scanner(System.in);
		double price = 0.0, change;
		
		MakeChange1 calculation = new MakeChange1();

		System.out.println("Welcome to the store, how much was the item ?");
		double cost = keyboard.nextDouble();

		System.out.println("How much money was tedered from the customer ? ");
		double moneyTendered = keyboard.nextDouble();

		while (moneyTendered < cost) {
			Scanner retry = new Scanner(System.in);
			
			System.out.println("Sorry thats less than the cost of the item, please type Y try again");
			String tryAgain = retry.next();
			if(tryAgain.equalsIgnoreCase("y")) {
				initialPrompt();
			}
			else {
				break;
			}
		}

		if (moneyTendered > cost) {
			change =  moneyTendered - cost;
			calculation.doCalculation(price, moneyTendered);
			System.out.println("The change is " + change );
		}
		if (moneyTendered == cost) {
			System.out.println("Thank you for the exact change ");
		}
		keyboard.close();
	}
}
