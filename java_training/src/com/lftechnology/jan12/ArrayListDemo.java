package com.lftechnology.jan12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create an array list with 49 Integer objects containing the numbers 1 through 49. It then randomly shuffles the list and selects the
 * first 6 values from the shuffled list. Finally, it sorts the selected values and prints them out. Hint: Use ArrayList,
 * Collections.shuffle(), ArrayList.subList(), and Collection.sort().
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class ArrayListDemo {
	private static final Logger LOGGER = Logger.getLogger(ArrayListDemo.class.getName());

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		int rangeStart = 1;
		int rangeEnd = 49;

		addElementsToList(numbers, rangeStart, rangeEnd);
		LOGGER.log(Level.INFO, "The numbers are: {0}", numbers);

		Collections.shuffle(numbers);
		LOGGER.log(Level.INFO, "The numbers after shuffling are: {0}", numbers);

		List<Integer> selectedNumbers = numbers.subList(0, 6);
		LOGGER.log(Level.INFO, "The first six numbers after shuffling are: {0}", selectedNumbers);
		Collections.sort(selectedNumbers);
		LOGGER.log(Level.INFO, "The selected Numbers after sorting: {0}", selectedNumbers);
	}

	/**
	 * Adds numbers specified from {@link Integer} value <code>begin</code>(inclusive) to {@link Integer} value <code>end</code>(inclusive)
	 * to the {@link List}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 * @param numbers
	 */
	public static void addElementsToList(List<Integer> numbers, int begin, int end) {
		for (int i = begin; i <= end; i++) {
			numbers.add(i);
		}
	}
}
