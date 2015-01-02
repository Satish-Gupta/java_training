package dec29;

/**
 * Find the number of and sum of all integers greater than 100 and less than 200
 * that are divisible by 7.
 * 
 * This class adds all integers greater than 100 and less than 200 and divisible
 * by seven.
 * 
 * @author satish
 *
 */
public class DivisibleBySeven {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 101; i < 200; i++) {
			if (i % 7 == 0) {
				sum += i;
				System.out.println(i + " " + sum);
			}
		}

		System.out
				.println("Sum of all number between 100 and 200 and divisible by 7 is: "
						+ sum);

	}

}
