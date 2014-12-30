/**
 * Program which accepts integer values and prints the exception
 * thrown when the integer value is out of its range
 */
package dec26;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class asks user for integer and if the value is greater then the maximum value of 
 * int datatype then the exception caught is handled and the exception displayed else the value
 * is displayed.
 * 
 * @author satish
 *
 */
public class IntegerDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter an integer value. Try the number 2147483648");

		try {
			int integerNumber = scanner.nextInt();
			System.out.println("The number you entered: " + integerNumber);
		} catch (InputMismatchException exception) {
			System.err.println(exception);
		} finally {
			scanner.close();
		}
	}

}
