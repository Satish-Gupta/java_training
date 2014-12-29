/**
 * WAP which gets three arguments from the console i.e initials, first name, mid name and 
 * last name and concatenates all the values and displays the full name
 */
package dec26;

import java.util.Scanner;

/**
 * @author satish
 *
 */
public class GetFullName {

	public static void main(String[] args) {
		String initials = "";
		String firstName = "";
		String midName = "";
		String lastName = "";
		String fullName = "";

		// to take response from the user if he/she wants to skip certain inputs
		String ans = "";
		Scanner scanner = new Scanner(System.in);

		// get initials part of Name
		do {
			System.out.println("Please Enter your initials");

			initials = scanner.nextLine().trim();

			if (initials.isEmpty()) {
				System.out.println("Skip initials y/n");
				ans = scanner.nextLine();
				System.out.println(ans);
			} else {
				ans = "";
			}

		} while (ans.equalsIgnoreCase("n"));

		// get first Name
		do {
			System.out.println("Please Enter your First Name");
			firstName = scanner.nextLine().trim();
		} while (firstName.isEmpty());

		// get middle name
		do {
			System.out.println(" Please Enter your Middle Name");
			midName = scanner.nextLine().trim();

			if (midName.isEmpty()) {
				System.out.println("Skip middle name y/n");
				ans = scanner.nextLine();
			} else {
				ans = "";
			}
		} while (ans.equalsIgnoreCase("n"));

		// get last name
		do {
			System.out.println(" Please Enter your Last Name");
			lastName = scanner.nextLine().trim();

			if (lastName.isEmpty()) {
				System.out.println("Skip last y/n");
				ans = scanner.nextLine().trim();
			} else {
				ans = "";
			}
		} while (ans.equalsIgnoreCase("n"));

		fullName += initials;

		// add space after intials if initials is not empty
		if (!initials.isEmpty()) {
			fullName += " ";
		}

		fullName += firstName;

		// add space after first name if midName is not empty
		if (!midName.isEmpty()) {
			fullName += " ";
		}

		fullName += midName;

		// add space after midName if lastName is not empty
		if (!lastName.isEmpty()) {
			fullName += " ";
		}

		fullName += lastName;

		System.out.println("Your fullName is:" + fullName);

		scanner.close();
	}

}
