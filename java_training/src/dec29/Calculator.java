/**
 *
 */
package dec29;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program using switch statement to develop a simple calculator for +,
 * -, *, /, and % operators.
 * 
 * @author satish
 *
 */
public class Calculator {

	// for display of operation supported
	final static String[] OPERATIONS = { "Addition", "Subtraction",
			"Multiplication", "Division", "Modulus" };
	// operators supported
	final static char[] OPERATORS = { '+', '-', '*', '/', '%' };

	public static char operator = ' ';
	public static double operand1 = 0;
	public static double operand2 = 0;
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @param operand1
	 *            first operand
	 * 
	 * @param operand2
	 *            second operand
	 * 
	 * @return result after add operation
	 */
	public static double add(double operand1, double operand2) {
		return operand1 + operand2;
	}

	/**
	 * @param operand1
	 *            first operand
	 * 
	 * @param operand2
	 *            second operand
	 * 
	 * @return result after subtract operation
	 */
	public static double subtract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	/**
	 * @param operand1
	 *            first operand
	 * 
	 * @param operand2
	 *            second operand
	 * 
	 * @return result after multiply operation
	 */
	public static double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	/**
	 * @param operand1
	 *            first operand
	 * 
	 * @param operand2
	 *            second operand
	 * 
	 * @return result after divide operation
	 * 
	 * @throw ArithmeticException when operand2 is zero
	 */
	public static Double divide(double operand1, double operand2) {
		try {
			if (operand2 == 0) {
				throw new ArithmeticException("Division by zero");
			}
			return operand1 / operand2;
		} catch (ArithmeticException exception) {
			System.err.println(exception);
			return null;
		}

	}

	/**
	 * @param operand1
	 *            first operand
	 * 
	 * @param operand2
	 *            second operand
	 * 
	 * @return result after mod operation
	 * 
	 * @throw ArithmeticException when operand2 is zero
	 */
	public static Double getRemainder(double operand1, double operand2) {
		try {
			if (operand2 == 0) {
				throw new ArithmeticException("Division by zero");
			}
			return operand1 % operand2;
		} catch (ArithmeticException exception) {
			System.err.println(exception);
			return null;
		}
	}

	/**
	 * displays options for the operations to be performed and get the operation
	 * that user wants to perform. displays appropriate message for wrong choice
	 * and let the user correct that.
	 * 
	 * @throws InputMismatchException
	 *             if the user enters non-numerical data for operands or invalid
	 *             operation option.
	 */
	public static char getOperator() {
		int choice = -1;
		boolean isChoiceValid = false;
		System.out.println("Select the operation you want to perform:");
		for (int i = 0; i < OPERATIONS.length; i++) {
			System.out.println((i + 1) + "." + OPERATIONS[i] + "("
					+ OPERATORS[i] + ")");
		}

		do {
			try {
				choice = scanner.nextInt();
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
			operator = OPERATORS[choice - 1];
		}

		return operator;

	}

	/**
	 * takes operand as input from the user and in case non-numerical value is
	 * pressed dispaly appropriate message and asks user to give numberical
	 * value.
	 * 
	 * @return numerical value
	 */
	public static double getOperand() {
		boolean isInputFormatCorrect = false;
		double operand = 0;

		do {
			try {
				operand = scanner.nextDouble();
				isInputFormatCorrect = true;
			} catch (InputMismatchException e) {
				System.out
						.println("You did not enter a number. Please enter a number");
			}
		} while (!isInputFormatCorrect);
		return operand;

	}

	public static void main(String[] args) {

		double result = 0;
		operator = getOperator();

		// for divide by zero operation
		boolean isOperand2Zero = false;

		System.out.println("Enter the first number");
		operand1 = getOperand();

		System.out.println("Enter the second number");
		operand2 = getOperand();

		switch (operator) {
		case '+':
			result = add(operand1, operand2);
			break;
		case '-':
			result = subtract(operand1, operand2);
			break;
		case '*':
			result = multiply(operand1, operand2);
			break;
		case '/':
			do {
				Double tempResult = divide(operand1, operand2);
				if (tempResult != null) {
					isOperand2Zero = false;
					result = tempResult;
				} else {
					isOperand2Zero = true;
					System.out
							.println("Please enter non-zero value for denominator");
					operand2 = getOperand();
				}
			} while (isOperand2Zero);
			break;
		case '%':
			do {
				Double tempResult = getRemainder(operand1, operand2);
				if (tempResult != null) {
					isOperand2Zero = false;
					result = tempResult;
				} else {
					isOperand2Zero = true;
					System.out
							.println("Please enter non-zero value for denominator");
					// to clear scanner buffer
					// System.out.println(scanner.nextDouble());
					operand2 = getOperand();
				}
			} while (isOperand2Zero);

			break;
		default:
			System.out.println("Wrong Input");
			break;
		}

		System.out.println(operand1 + " " + operator + " " + operand2 + " = "
				+ result);
		scanner.close();

	}

}
