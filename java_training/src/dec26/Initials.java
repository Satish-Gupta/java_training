/**
 * WAP that computes your initials from your full name and displays them.
 */
package dec26;

import java.util.Scanner;

/**
 * This class asks user to input his name and if the name consists of initials then it is 
 * displayed to the user else appropriate message is shown.
 * 
 * @author satish
 *
 */
public class Initials {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Name with initials");
		String name = scanner.nextLine();
		String emptyString ="";
		String namefirstPart = "";
		
		int firstSpaceIndex = name.indexOf(" ");
		// get the substring before the first space to avoid taking initials in names having abreviated middlename
		if(firstSpaceIndex!= -1) {
			namefirstPart = name.substring(0, firstSpaceIndex + 1);
		}
		String nameInitials = namefirstPart.substring(0, namefirstPart.indexOf(".") + 1);
		
		if(!nameInitials.equals(emptyString)) {
			System.out.println("Your initials: " + nameInitials);
		} else {
			System.out.println("you did not give initials");
		}
		
		scanner.close();
	}

}
