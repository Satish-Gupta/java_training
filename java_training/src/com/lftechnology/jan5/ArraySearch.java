package com.lftechnology.jan5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Search for a specific value in an array.
 * 
 * @author satish
 * 
 */
public class ArraySearch {
	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(ArraySearch.class.getName());
	private static String[] items = null;
	private static String key = "";

	public static void main(String[] args) {
		try {
			getItems();

			System.out.println("Enter the item to be searched");
			key = scanner.next();
			searchKey();
		} finally {
			scanner.close();
		}
	}

	/**
	 * reads the items and populates it to the items array
	 */
	private static void getItems() {
		int numberOfItems = 0;
		boolean isInputValid = true;

		System.out.println("Enter the number of items to be stored");

		do {
			try {
				numberOfItems = Math.abs(scanner.nextInt());
				isInputValid = true;
			} catch (InputMismatchException exception) {
				isInputValid = false;
				scanner.nextLine();
				LOGGER.severe("Wrong input. Please enter a number");
			}
		} while (!isInputValid);

		items = new String[numberOfItems];

		System.out.println("Enter the numbers");
		for (int i = 0; i < numberOfItems; i++) {
			items[i] = scanner.next();
		}

	}

	/**
	 * searches an array for a given key and displays the result
	 */
	private static void searchKey() {
		boolean isFound = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equalsIgnoreCase(key)) {
				isFound = true;
				LOGGER.info("key: " + key + " found at:" + (i + 1));
			}
		}
		if (!isFound) {
			LOGGER.info("key: " + key + " not found");
		}
	}
}
