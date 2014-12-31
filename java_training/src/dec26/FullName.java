package dec26;

import java.util.Scanner;

/**
 * WAP which gets three arguments from the console i.e initials, first name, mid
 * name and last name and concatenates all the values and displays the full name
 * This class ask user to input his name initials, first name , middle name,
 * last name one by one and computes his full Name which is then displayed.
 * 
 * @author satish
 *
 */
public class FullName {

	public static void main(String[] args) {
		String nameInitials = "";
		String firstName = "";
		String midName = "";
		String lastName = "";
		String fullName = "";
		final String ANSWER_NOT = "n";
		final char NAME_SEPARATOR = ' ';

		// to take response from the user if he/she wants to skip certain inputs
		String ans = "";
		Scanner scanner = new Scanner(System.in);

		// get initials part of Name
		do {
			System.out.println("Please Enter your initials");

			nameInitials = scanner.nextLine().trim();

			ans = "";

			if (nameInitials.isEmpty()) {
				System.out.println("Skip initials y/n");
				ans = scanner.nextLine();
				System.out.println(ans);
			}

		} while (ans.equalsIgnoreCase(ANSWER_NOT));

		// get first Name
		do {
			System.out.println("Please Enter your First Name");
			firstName = scanner.nextLine().trim();
		} while (firstName.isEmpty());

		// get middle name
		do {
			System.out.println(" Please Enter your Middle Name");
			midName = scanner.nextLine().trim();

			ans = "";

			if (midName.isEmpty()) {
				System.out.println("Skip middle name y/n");
				ans = scanner.nextLine();
			}

		} while (ans.equalsIgnoreCase(ANSWER_NOT));

		// get last name
		do {
			System.out.println(" Please Enter your Last Name");
			lastName = scanner.nextLine().trim();

			ans = "";

			if (lastName.isEmpty()) {
				System.out.println("Skip last y/n");
				ans = scanner.nextLine().trim();
			}
		} while (ans.equalsIgnoreCase(ANSWER_NOT));

		fullName += nameInitials;

		// add space after intials if initials is not empty
		if (!nameInitials.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += firstName;

		// add space after first name if midName is not empty
		if (!midName.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += midName;

		// add space after midName if lastName is not empty
		if (!lastName.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += lastName;

		System.out.println("Your fullName is:" + fullName);

		scanner.close();
	}

}
