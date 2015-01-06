package com.lftechnology.jan5;

import java.util.logging.Logger;

/**
 * Compare if two arrays have the same content (doesn't matter if they aren't in
 * order)
 * 
 * @author satish
 * 
 */
public class ArrayContentMatch {
	private static Logger logger = Logger.getLogger(ArrayContentMatch.class
			.getName());

	/**
	 * checks if two arrays have same content irrespective of the order
	 * 
	 * @param array1
	 * @param array2
	 * @return true if two arrays have same content and in same order else
	 *         return false
	 */
	private static boolean arrayMatch(String[] comparisionArray1,
			String[] comparisionArray2) {
		int array1Length = comparisionArray1.length;
		int array2Length = comparisionArray2.length;
		// to track the count of matches between two arrays
		int elementMatchCount = 0;

		if (array1Length != array2Length) {
			return false;
		}
		/*
		 * clone array 2 so that it can be marked with null after it has been
		 * matched with an element avoiding it to match again for another same
		 * value element
		 */
		String[] tempArray = comparisionArray2.clone();

		for (int i = 0; i < array1Length; i++) {
			for (int j = 0; j < array2Length; j++) {

				if (comparisionArray1[i] != null
						&& comparisionArray1[i].equals(tempArray[j])) {
					/*
					 * mark the element that has already been matched with some
					 * element
					 */
					tempArray[j] = null;
					elementMatchCount++;
					break;
				}
			}
		}
		/* check if the match count was equal to length of any one array */
		if (elementMatchCount == array1Length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] myArray = { "aa", "dd", "cc", "bb" };
		String[] comparisionArrray = { "aa", "dd", "cc", "bb" };
		boolean isArrayMatch = false;

		isArrayMatch = arrayMatch(myArray, comparisionArrray);
		if (isArrayMatch) {
			logger.info("The given two arrays match with each other ");
		} else {
			logger.info("The given two arrays does not match with each other ");
		}
	}

}
