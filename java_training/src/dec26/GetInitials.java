/**
 * WAP that computes your initials from your full name and displays them.
 */
package dec26;

import java.util.Scanner;

/**
 * @author satish
 *
 */
public class GetInitials {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.nextLine();
		
		if(name.startsWith("Mr.")) {
			System.out.println(name.substring(0, 3));
		} else if(name.startsWith("Mrs.")) {
			System.out.println(name.substring(0, 4));
		} else {
			System.out.println("Yout did not mention your initials");
		}
		
		scanner.close();
	}

}
