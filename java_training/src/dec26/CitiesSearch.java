/**
 * WAP which accepts name of cities. Ask a user to enter the character sequence to search
 * in the cities and display the matched cities.
 */
package dec26;

import java.util.Scanner;

/**
 * @author satish
 *
 */
public class CitiesSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfCities;
		String[] cities = null;
		String searchStr = "";
		
		System.out.println("Enter the number of cities");
		numberOfCities = scanner.nextInt();
		
		cities = new String[numberOfCities];
		
		System.out.println("Enter cities");
		
		for(int i = 0; i < numberOfCities; i++) {
			cities[i] = scanner.nextLine();
		}
		
		System.out.println("The cities are");
		for(int i = 0; i < numberOfCities; i++) {
			System.out.print(cities[i] + ' ');
		}		
		
		System.out.println("\nEnter the search string");
		searchStr = scanner.next();
		
		for(int i = 0; i < cities.length; i++) {
			if(cities[i].contains(searchStr)) {
				System.out.print(cities[i] + ' ');
			}
		}
		
		scanner.close();
	}

}
