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
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * gets a part of the full name from the user. If the user presses enter
	 * without specifying anything then user is asked if he really intends to
	 * skip that part. If the input is the first name then the user is not shown
	 * the skip prompt.
	 * 
	 * @param namePartName
	 *            part of the full name that needs to be read from the user
	 * @return the part of the full name that was taken as input from the user
	 */
	public static String getPartOfName(String namePartName) {
		String namePart = "";
		String ans = "";
		boolean isSkipingNamePart = false;
		do {
			System.out.println("Enter your " + namePartName);

			namePart = scanner.nextLine().trim();

			// check if input is empty and the input is not the first name
			if (namePart.isEmpty() && !namePartName.equals("first name")) {

				// show skip message
				System.out.println("skip " + namePartName + " y/n");

				ans = scanner.nextLine();

				if (ans.equals("y")) {
					isSkipingNamePart = true;
				}
				// check if name is empty but the input is first name
			} else if (namePart.isEmpty() && namePartName.equals("first name")) {
				isSkipingNamePart = false;
				/*
				 * set skip messege true if namePart not empty i.e user entered
				 * the input
				 */
			} else {
				isSkipingNamePart = true;
			}

		} while (!isSkipingNamePart);

		return namePart;
	}

	/**
	 * @param nameInitials
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @return the fullName created by appending the fullnameParts
	 */
	public static String generateFullName(String nameInitials,
			String firstName, String middleName, String lastName) {
		String fullName = "";
		final char NAME_SEPARATOR = ' ';

		fullName += nameInitials;

		// add space after intials if initials is not empty
		if (!nameInitials.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += firstName;

		// add space after first name if midName is not empty
		if (!middleName.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += middleName;

		// add space after midName if lastName is not empty
		if (!lastName.isEmpty()) {
			fullName += NAME_SEPARATOR;
		}

		fullName += lastName;

		return fullName;
	}

	public static void main(String[] args) {

		String nameInitials = "";
		String firstName = "";
		String midName = "";
		String lastName = "";
		String fullName = "";

		// to take response from the user if he/she wants to skip certain inputs
		Scanner scanner = new Scanner(System.in);

		// get initials part of Name
		nameInitials = getPartOfName("initials");
		// get first Name
		firstName = getPartOfName("first name");
		// get middle name
		midName = getPartOfName("middle name");
		// get last name
		lastName = getPartOfName("last name");

		fullName = generateFullName(nameInitials, firstName, midName, lastName);
		System.out.println("Your fullName is: " + fullName);

		scanner.close();
	}
}
