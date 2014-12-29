/**
 * 	Create a class MutableAndImmutableDemo. Inside that class crate object greeting of String
 * and another object welcome of StringBuilder type. Try to modify by concating some string as
 * a suffix.
 */
package dec26;

/**
 * @author satish
 *
 */
public class MutableAndImmutableDemo {

	public static void main(String[] args) {

		String greetings = "Welcome";

		// try concating a string to greetings
		greetings.concat("EveryOne");

		System.out.println(greetings);

		// check what String.concat(String) returns
		System.out.println(greetings.concat("EveryOne"));

		StringBuilder welcomeString = new StringBuilder("Welcome Everyone");
		welcomeString.append("!!!");

		System.out.println(welcomeString);

	}

}
