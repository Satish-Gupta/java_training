/**
 *  Write a program that displays the temperatures from 0 degrees Celsius to 100 degrees Celsius and its Fahrenheit equivalent. 
 *  Note that the conversion from Celsius to Fahrenheit uses the following formula: F = C * 9/5 + 32;
 */
package dec29;

/**
 * @author satish
 *
 */
public class CelciusToFahrenheit {

	public static void main(String[] args) {
		
		for(int i = 0; i < 100; i++) {
			double temparatureInCelcius = i;
			double temparatureInFahrenheit = temparatureInCelcius * 9 / 5 + 32;
			System.out.println(temparatureInCelcius + "deg C =" + temparatureInFahrenheit + "deg F" );
		}
	}

}
