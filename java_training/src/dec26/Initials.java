/**
 * WAP that computes your initials from your full name and displays them.
 */
package dec26;

import java.util.Scanner;

/**
 * @author satish
 *
 */
public class Initials {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Name with initials");
		String name = scanner.nextLine();
		
		if(name.toLowerCase().startsWith("mr.")) {
			System.out.println(name.substring(0, 3));
		} else if(name.toLowerCase().startsWith("mrs.")) {
			System.out.println(name.substring(0, 4));
		} else {
			System.out.println("Yout did not mention your initials");
		}
		
		scanner.close();
	}

}
