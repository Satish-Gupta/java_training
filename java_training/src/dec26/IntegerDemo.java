/**
 * Program which accepts integer values and prints the exception
 * thrown when the integer value is out of its range
 */
package dec26;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author satish
 *
 */
public class IntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter an integer value. Try the number 2147483648");

		try {			
			int integerNumber = scanner.nextInt();		
			System.out.println("The number you entered: " + integerNumber);			
		} catch(InputMismatchException exception) {			
			exception.printStackTrace();			
		}
		
		scanner.close();
	}

}
