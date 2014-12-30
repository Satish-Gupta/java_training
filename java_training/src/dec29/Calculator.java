/**
 * Write a program using switch statement to develop a simple calculator for +, -, *, /, and % operators.
 */
package dec29;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class simulates a basic two operand calculator.
 * 
 * @author satish
 *
 */
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String operator = "";
		final String[] OPERATIONS = { "Addition", "Subtraction", "Multiplication",
				"Division", "Modulus" };
		final String[] OPERATORS = { "+", "-", "*", "/", "%" };
		double operand1 = 0;
		double operand2 = 0;
		double result = 0;
		int choice = -1;
		boolean isChoiceValid = false;
		
		boolean isInputFormatCorrect = false;

		System.out.println("Select the operation you want to perform:");
		for (int i = 0; i < OPERATIONS.length; i++) {
			System.out.println((i + 1) + "." + OPERATIONS[i] + "("
					+ OPERATORS[i] + ")");
		}

		
		try {
			do {
				try {
					choice = scanner.nextInt();
					isInputFormatCorrect = true;
					isChoiceValid = choice >= 1 && choice <= 5;
					if(!isChoiceValid) {
						System.out.println("Please select valid option");
					}

				} catch (InputMismatchException e) {
					System.out
							.println("You did not enter a number. Please enter a number");
					// to clear the scanner buffer
					scanner.nextLine();
				}
			} while (!isChoiceValid);

			// get operator for the selected option
			if(isChoiceValid) {
				// get operator for the selected option
				operator = OPERATORS[choice - 1];
			}
			

			// reset isCorrectInputFormat to reuse it for first number
			isInputFormatCorrect = false;

			System.out.println("Enter the first number");
			do {
				try {
					operand1 = scanner.nextDouble();
					isInputFormatCorrect = true;
				} catch (InputMismatchException e) {
					System.out
							.println("You did not enter a number. Please enter a number");
					// to clear the scanner buffer
					scanner.nextLine();
				}
			} while (!isInputFormatCorrect);

			// reset isCorrectInputFormat to reuse it for second number
			isInputFormatCorrect = false;
			System.out.println("Enter the second number");

			do {
				try {
					operand2 = scanner.nextDouble();
					isInputFormatCorrect = true;
				} catch (InputMismatchException e) {
					System.out
							.println("You did not enter a number. Please enter a number");
					// to clear the scanner buffer
					scanner.nextLine();
				}
			} while (!isInputFormatCorrect);
		} finally {
			scanner.close();
		}

		switch (operator) {
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			try {
				if (operand2 == 0) {
					throw new ArithmeticException("Division by zero");
				}
				result = operand1 / operand2;
			} catch (Exception e) {
				System.out.println(e);
				return;
			} finally {
				scanner.close();
			}
			break;
		case "%":
			result = operand1 % operand2;
			break;
		default:
			System.out.println("Wrong Input");
			break;
		}

		System.out.println(operand1 + " " + operator + " " + operand2 + " = "
				+ result);

	}

}
