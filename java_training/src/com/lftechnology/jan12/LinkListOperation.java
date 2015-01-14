package com.lftechnology.jan12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 5.
 * <ul>
 * <li>Create a linked list named one and two.</li>
 * <li>Add some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten).</li>
 * <li>Merge the words from two into one.</li>
 * <li>Remove every second word from two.</li>
 * <li>Remove all words in two from one. f. Print the value after each operation.</li>
 * </ul>
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class LinkListOperation {
	private static Logger LOGGER = Logger.getLogger(LinkListOperation.class.getName());

	public static void main(String[] args) {

		List<String> WORD_LIST_ONE = new ArrayList<String>(Arrays.asList("one", "two", "three", "four", "five"));
		List<String> WORD_LIST_TWO = new ArrayList<String>(Arrays.asList("six", "seven", "eight", "nine", "ten"));
		WordList one = new WordList(WORD_LIST_ONE);
		WordList two = new WordList(WORD_LIST_TWO);

		LOGGER.log(Level.INFO, "List one: {0}", one);
		LOGGER.log(Level.INFO, "List two:{0}", two);

		LOGGER.log(Level.INFO, "merging elements from two to one");
		one.merge(two);

		LOGGER.log(Level.INFO, "List one:{0}", one);
		LOGGER.log(Level.INFO, "List two:{0}", two);

		LOGGER.log(Level.INFO, "removing every second element from two");
		// remove every second element from second word list
		two.removeEverySecondWord();
		LOGGER.log(Level.INFO, "Main words List:{0}", one);
		LOGGER.log(Level.INFO, "Secondary words List:{0}", two);

		// remove elements of second list from the first
		one.getList().removeAll(two.getList());
		LOGGER.log(Level.INFO, "Main words List:{0}", one);
		LOGGER.log(Level.INFO, "Secondary words List:{0}", two);
	}
}
