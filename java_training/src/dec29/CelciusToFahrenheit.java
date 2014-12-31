package dec29;

/**
 * Write a program that displays the temperatures from 0 degrees Celsius to 100
 * degrees Celsius and its Fahrenheit equivalent. Note that the conversion from
 * Celsius to Fahrenheit uses the following formula: F = C * 9/5 + 32;
 * 
 * This class converts degree celcius value from 0 to 100 to it fahrenheit
 * equivalent.
 * 
 * @author satish
 *
 */
public class CelciusToFahrenheit {

	public static void main(String[] args) {
		final String CELCIUS_UNIT = "\u2103";
		final String FAHRENHEIT_UNIT = "\u2103";

		for (int i = 0; i < 100; i++) {
			double temparatureInCelcius = i;
			double temparatureInFahrenheit = temparatureInCelcius * 9 / 5 + 32;
			System.out.println(temparatureInCelcius + CELCIUS_UNIT + " = "
					+ temparatureInFahrenheit + FAHRENHEIT_UNIT);
		}
	}

}
