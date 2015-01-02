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

	/**
	 * interacts with the user and enable the user to play the game
	 * 
	 * @param numberGuess
	 *            the instance that holds the secret number and other data for
	 *            the game and performs guesses on the secret number
	 * @param scanner
	 */
	public static void playGame(NumberGuess numberGuess, Scanner scanner) {
		int userGuess = 0;
		// to determine if user wants to continue playing or end the game
		String userResponse = " ";
		boolean isEndGame = false;
		/*
		 * to determine if the user guess is correct (0), greater than(1) or
		 * less than(-1)
		 */
		int guessState = 0;

		System.out.println("Please enter your guess");
		try {
			do {
				try {
					userGuess = scanner.nextInt();

					guessState = numberGuess.guessNumber(userGuess);

					// if guess does equal to the random (secret) number
					if (guessState == 0) {
						numberGuess.isGuessHit = true;
					} else {
						System.out.println("Wrong guess.");

						// check if user guess is less than the secret number
						if (guessState == -1) {
							System.out
									.println("your guess is less than the secret number");

							// check if user guess is greater than the secret
							// number
						} else if (guessState == 1) {
							System.out
									.println("your guess is greater than the secret number");
						}
						System.out
								.println("Press n to end or any other key to try again");
						// user input that determines if he wants to continue
						// guessing or give up
						userResponse = scanner.next();

						// check if user chose to give up or the maximum allowed
						// trial have been reached
						if (userResponse.toLowerCase().equals("n")
								|| numberGuess.MAX_ATTEMPT_ALLOWED <= numberGuess.guesses
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

			} while (guessState != 0 && !isEndGame);

		} finally {
			scanner.close();
		}

	}

	/**
	 * shows the result of the game as the user loses or wins the game
	 * 
	 * @param numberGuess
	 *            the instance that holds the secret number and other data for
	 *            the game and performs guesses on the secret number
	 */
	public static void showResult(NumberGuess numberGuess) {
		// if user guess hits the secret number
		if (numberGuess.isGuessHit) {
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
		} else {
			System.out.println("Game Over!! you lost");
			System.out.println("The secret number is:"
					+ numberGuess.RANDOM_NUMBER);
			System.out.println("your guesses:");
			Iterator<Integer> iterator = numberGuess.guesses.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// lower bound of the range for the secret number (exclusive)
		int startRange = 1;
		// uppr bound of the range for secret number (inclusive)
		int endRange = 100;
		NumberGuess numberGuess = new NumberGuess(startRange, endRange, 10);
		System.out.println("Number Guessing game");
		System.out.println("Range: " + numberGuess.rangeStart + " to"
				+ numberGuess.rangeEnd);

		playGame(numberGuess, scanner);

		showResult(numberGuess);
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
	public final int MAX_ATTEMPT_ALLOWED;
	public boolean isGuessHit = false;
	public Collection<Integer> guesses = null;

	/**
	 * @param rangeStart
	 * @param rangeEnd
	 * @param maxAttempAllowed
	 */
	NumberGuess(int rangeStart, int rangeEnd, int maxAttempAllowed) {
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.MAX_ATTEMPT_ALLOWED = maxAttempAllowed;
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
	public int guessNumber(int guess) {
		guesses.add(guess);

		if (guess > RANDOM_NUMBER) {
			return 1;
		} else if (guess < RANDOM_NUMBER) {
			return -1;
		}
		return 0;
	}
}
