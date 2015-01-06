package com.lftechnology.jan5;

import java.util.logging.Logger;

/**
 * Compare if two arrays have the same content (in the same order)
 * 
 * @author satish
 * 
 */
public class ArrayMatch {
	private static Logger logger = Logger.getLogger("myLogger");

	/**
	 * checks if two arrays have same content and in same order
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
		if (array1Length != array2Length) {
			return false;
		}
		int i = 0;
		for (; i < array1Length; i++) {
			if (!comparisionArray1[i].equalsIgnoreCase(comparisionArray2[i])) {
				break;
			}
		}
		if (i == array1Length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] myArray = { "aa", "bb", "cc", "dd" };
		String[] comparisionArray = { "aa", "bbc", "cc", "dd" };
		boolean isArrayMatch = false;

		isArrayMatch = arrayMatch(myArray, comparisionArray);
		if (isArrayMatch) {
			logger.info("The given two arrays match with each other ");
		} else {
			logger.info("The given two arrays does not match with each other ");
		}
	}

}
