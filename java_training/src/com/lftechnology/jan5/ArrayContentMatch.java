package com.lftechnology.jan5;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Compare if two arrays have the same content (doesn't matter if they aren't in order)
 * 
 * @author satish
 * 
 */
public class ArrayContentMatch {
	private static final Logger LOGGER = Logger.getLogger(ArrayContentMatch.class.getName());

	/**
	 * checks if two arrays have same content irrespective of the order
	 * 
	 * @param array1
	 * @param array2
	 * @return true if two arrays have same content and in same order else return false
	 */
	private static boolean arrayMatch(String[] comparisionArray1, String[] comparisionArray2) {
		int array1Length = comparisionArray1.length;
		int array2Length = comparisionArray2.length;

		if (array1Length != array2Length) {
			return false;
		}

		// here the sort won't be correct if the arrays contain numerical values
		// which we don't care since if the two arrays have same elements in different order
		// the result for both will be same irrespective of the correctness of the sort
		Arrays.sort(comparisionArray1);
		Arrays.sort(comparisionArray2);

		int i = 0;
		for (; i < array1Length; i++) {
			if (!comparisionArray1[i].equals(comparisionArray2[i])) {
				break;
			}
		}
		/*
		 * check if the i is equal to length of any one array which determines if the sorted array contents matched till the end of teh
		 * arrays
		 */
		if (i == array1Length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] myArray = { "aa", "5", "dd", "31", "cc", "bb" };
		String[] comparisionArrray = { "aa", "31", "bb", "5", "cc", "dd" };
		boolean isArrayMatch = false;

		isArrayMatch = arrayMatch(myArray, comparisionArrray);
		if (isArrayMatch) {
			LOGGER.info("The given two arrays match with each other ");
		} else {
			LOGGER.info("The given two arrays does not match with each other ");
		}
	}

}
