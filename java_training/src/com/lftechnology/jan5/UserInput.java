package com.lftechnology.jan5;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Try to do a program that constantly prompts the user to enter something (using the Scanner class) until the user enters a specific word
 * (such as quit for example)
 * 
 * @author satish
 * 
 */
public class UserInput {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(UserInput.class.getName());

	public static void main(String[] args) {
		String userInput = "";
		final String QUIT = "quit";
		try {
			do {
				System.out.println("Enter something or enter quit to exit");
				userInput = scanner.nextLine();
				if (userInput.equalsIgnoreCase(QUIT)) {
					break;
				}
				LOGGER.info(userInput + " Entered");
			} while (true);
		} finally {
			scanner.close();
		}
	}
}
