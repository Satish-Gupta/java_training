package dec26;

import java.util.Scanner;

/**
 * WAP which accepts name of cities. Ask a user to enter the character sequence
 * to search in the cities and display the matched cities. This class takes asks
 * user to enter cities and a search string and displays any cities that
 * contains the search string. If no match is found it displays the appropriate
 * message.
 * 
 * @author satish
 *
 */
public class CitiesSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfCities = 0;
		String[] cities = null;
		String searchStr = "";

		System.out.println("Enter the number of cities");
		numberOfCities = scanner.nextInt();

		cities = new String[numberOfCities];

		System.out.println("Enter cities");

		for (int i = 0; i < numberOfCities; i++) {
			cities[i] = scanner.nextLine();
		}

		System.out.println("The cities are");
		for (int i = 0; i < numberOfCities; i++) {
			System.out.print(cities[i] + ',');
		}

		System.out.println("Enter the search string");
		searchStr = scanner.next();

		boolean isFound = false;
		for (int i = 0; i < numberOfCities; i++) {
			if (cities[i].toLowerCase().contains(searchStr.toLowerCase())) {
				// show listing message if this is the first match
				if (!isFound) {
					System.out.println("The cities found are: ");
				}
				System.out.println(cities[i]);
				isFound = true;
			}
		}

		// Display appropriate message if there is no cities containing the
		// search string
		if (!isFound) {
			System.out.println("No cities found for the given search string");
		}

		scanner.close();
	}

}
