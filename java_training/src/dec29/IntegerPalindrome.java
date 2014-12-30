/**
 * A palindrome is a sequence of characters that reads the same backward as forward. 
 * For example, each of the following five-digit integers is a palindrome: 12321, 55555, 45554 and 11611. 
 * Write an application that reads in a five-digit integer and determines whether it is a palindrome. 
 * If the number is not five digits long, display an error message and allow the user to enter a new value.
 */
package dec29;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author satish
 * 
 */
public class IntegerPalindrome {
	/**
	 * reverses the number passed as parameter and returns the reversed number.
	 * 
	 * @param number the number to be reversed
	 * @return reversedNumber the reversed number
	 *
	 */
	public static int reverseNumber(int number) {
		
		int reversedNumber = 0;

		// get the last digit
		int temp = number % 10;
		int i = 0;
		// subtract the last digit from the number
		number -= temp;

		while (number != 0) {

			reversedNumber = reversedNumber * 10 + temp / (int) Math.pow(10, i);
			temp = number % (int) Math.pow(10, i + 2);
			number = number - temp;

			i++;
		}
		reversedNumber = reversedNumber * 10 + temp / (int) Math.pow(10, i);

		return reversedNumber;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = 0;
		boolean isInputFormatCorrect = false;

		System.out.println("Enter a 5 digits number to check for palindrome");
		do {
			try {
				number = scanner.nextInt();

				if (Math.abs(number) > 99999 || Math.abs(number) <= 9999) {
					System.out
							.println("Given number is not a 5 digits number. Please enter 5 digits number");
				} else {
					isInputFormatCorrect = true;
				}
			} catch (InputMismatchException e) {
				System.out
						.println("You did not enter a number. Please enter a number");
				// to clear the scanner buffer
				scanner.nextLine();
			}
		} while (!isInputFormatCorrect);

		int reversedNumber = reverseNumber(number);

		if (reversedNumber == number) {
			System.out.println("The given number " + number + " is palindrome");
		} else {
			System.out.println("The given number " + number
					+ " is not a palindrome");
		}
		scanner.close();

	}

}
