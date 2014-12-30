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
	final static String[] OPERATIONS = { "Addition", "Subtraction",
			"Multiplication", "Division", "Modulus" };
	final static String[] OPERATORS = { "+", "-", "*", "/", "%" };
	public static String operator = "";
	static double operand1 = 0;
	static double operand2 = 0;

	/*
	 * @param operand1 first operand
	 * 
	 * @param operand2 second operand
	 * 
	 * @return result after add operation
	 */
	public static double add(double operand1, double operand2) {
		return operand1 + operand2;
	}
	
	/*
	 * @param operand1 first operand
	 * 
	 * @param operand2 second operand
	 * 
	 * @return result after subtract operation
	 */
	public static double subtract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	/*
	 * @param operand1 first operand
	 * 
	 * @param operand2 second operand
	 * 
	 * @return result after multiply operation
	 */
	public static double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	/*
	 * @param operand1 first operand
	 * 
	 * @param operand2 second operand
	 * 
	 * @return result after divide operation
	 */
	public static double divide(double operand1, double operand2) {
		return operand1 / operand2;
	}

	/*
	 * @param operand1 first operand
	 * 
	 * @param operand2 second operand
	 * 
	 * @return result after mod operation
	 */
	public static double getRemainder(double operand1, double operand2) {
		return operand1 % operand2;
	}

	/*
	 * take input from user for operand1,operand2 and operation to be performed
	 * accept input only if the operands are numerical data and the operation selected
	 * is a valid operation. asks the user for correct input if unexpected input provided.
	 * 
	 *   @throws InputMismatchException if the user enters non-numerical data for operands
	 *   		 or invalid operation option. 
	 */
	public static void getInput() {
		Scanner scanner = new Scanner(System.in);
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
					if (!isChoiceValid) {
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
			if (isChoiceValid) {
				// get operator for the selected option
				Calculator.operator = Calculator.OPERATORS[choice - 1];
			}

			// reset isCorrectInputFormat to reuse it for first number
			isInputFormatCorrect = false;

			System.out.println("Enter the first number");
			do {
				try {
					Calculator.operand1 = scanner.nextDouble();
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
					Calculator.operand2 = scanner.nextDouble();
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
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double result = 0;

		Calculator.getInput();

		switch (operator) {
		case "+":
			result = Calculator.add(operand1, operand2);
			break;
		case "-":
			result = Calculator.subtract(operand1, operand2);
			break;
		case "*":
			result = Calculator.multiply(operand1, operand2);
			break;
		case "/":
			try {
				if (operand2 == 0) {
					throw new ArithmeticException("Division by zero");
				}
				result = Calculator.divide(operand1, operand2);
			} catch (Exception e) {
				System.out.println(e);
				return;
			} finally {
				scanner.close();
			}
			break;
		case "%":
			result = Calculator.getRemainder(operand1, operand2);
			break;
		default:
			System.out.println("Wrong Input");
			break;
		}

		System.out.println(operand1 + " " + Calculator.operator + " "
				+ operand2 + " = " + result);

	}

}
