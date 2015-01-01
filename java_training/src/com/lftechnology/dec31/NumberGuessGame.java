package com.lftechnology.dec31;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1. Write a Guessing a number game application: User will select the guessing
 * value from the keyboard and application will generate a random no between 1
 * and 100. Check if the guess value matched with random no. or not, if matched
 * show the guessing value, random value and the no. of attempts.
 * 
 * @author satish
 *
 */
public class NumberGuessGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// lower bound of the range for the secret number (exclusive)
		int startRange = 1;
		// uppr bound of the range for secret number (inclusive)
		int endRange = 100;
		NumberGuess numberGuess = new NumberGuess(1, 100, 10);
		int userGuess = 0;
		boolean isGuessHit = false;
		// to determine if user wants to continue playing or end the game
		String userResponse = " ";
		boolean isEndGame = false;

		System.out.println("Number Guessing game");
		System.out.println("Range: " + numberGuess.rangeStart + " to"
				+ numberGuess.rangeEnd);
		System.out.println("Please enter your guess");

		try {
			do {
				try {
					userGuess = scanner.nextInt();

					if (numberGuess.guessNumber(userGuess)) {
						isGuessHit = true;
					} else {
						System.out
								.println("Wrong guess. Press n to end or any other key to try again");
						// user input that determines if he wants to continue
						// guessing or give up
						userResponse = scanner.next();

						// check if user chose to give up
						if (userResponse.toLowerCase().equals("n")
								|| numberGuess.maxAttemptAllowed <= numberGuess.guesses
										.size()) {
							isEndGame = true;

							// if user chose to continue
						} else {
							System.out.println("Enter your guess");
						}
					}
				} catch (InputMismatchException exception) {
					System.out
							.println("Wrong input. Please enter your guess(Number) between the valid range.");
					scanner.nextLine();
				}

			} while (!isGuessHit && !isEndGame);

		} finally {
			scanner.close();
		}

		// if user guess hit the secret number
		if (isGuessHit) {
			System.out.println("Congrats you won. you guessed it right");
			System.out.println("The correct number is:"
					+ numberGuess.RANDOM_NUMBER);
			System.out.println("Number of attempts:"
					+ numberGuess.guesses.size());
			System.out.println("your guesses:");
			Iterator<Integer> iterator = numberGuess.guesses.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		}
	}
}

/**
 * This class holds the data and methods for simulating a number guessing game.
 * 
 * @author satish
 *
 */
class NumberGuess {
	public final int RANDOM_NUMBER;
	public final int rangeStart;
	public final int rangeEnd;
	public final int maxAttemptAllowed;
	public Collection<Integer> guesses = null;

	/**
	 * @param rangeStart
	 * @param rangeEnd
	 * @param maxAttempAllowed
	 */
	NumberGuess(int rangeStart, int rangeEnd, int maxAttempAllowed) {
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.maxAttemptAllowed = maxAttempAllowed;
		RANDOM_NUMBER = generateRandomNumber();
		guesses = new LinkedList<Integer>();
	}

	/**
	 * @return the random(secret) number
	 */
	public int generateRandomNumber() {

		// generate random number between 1 to (rangeEnd - range Start -2)
		int tempRandom = (int) (Math.random() * (rangeEnd - rangeStart - 2)) + 1;

		return tempRandom + rangeStart;
	}

	/**
	 * @param guess
	 *            the user guess for the random (secret) number
	 * @return true if the user guess was right else false
	 */
	public boolean guessNumber(int guess) {
		guesses.add(guess);

		if (guess == RANDOM_NUMBER) {
			return true;
		}
		return false;
	}
}
