package com.lftechnology.jan12;

import java.util.LinkedList;
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

		final String[] WORD_LIST_ONE = { "one", "two", "three", "four", "five" };
		final String[] WORD_LIST_TWO = { "six", "seven", "eight", "nine", "ten" };

		WordList one = new WordList(getList(WORD_LIST_ONE));
		WordList two = new WordList(getList(WORD_LIST_TWO));

		LOGGER.log(Level.INFO, "List one: {0}", one);
		LOGGER.log(Level.INFO, "List two:{0}", two);

		LOGGER.log(Level.INFO, "merging elements from two to one");
		one.merge(two);

		LOGGER.log(Level.INFO, "List one:{0}", one);
		LOGGER.log(Level.INFO, "List two:{0}", two);

		LOGGER.log(Level.INFO, "removing every second element from one");
		// remove every second element from second word list
		two.removeEverySecondWord();
		LOGGER.log(Level.INFO, "Main words List:{0}", one);
		LOGGER.log(Level.INFO, "Secondary words List:{0}", two);

		// remove elements of second list from the first
		one.getList().removeAll(two.getList());
		LOGGER.log(Level.INFO, "Main words List:{0}", one);
		LOGGER.log(Level.INFO, "Secondary words List:{0}", two);
	}

	/**
	 * Creates {@link List} from a String array
	 * 
	 * @param words
	 *            string array for which {@link List} needs to be created
	 * @return {@link List} containing the string words of the supplied array.
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public static List<String> getList(String[] words) {
		List<String> wordsList = new LinkedList<String>();
		for (String word : words) {
			wordsList.add(word);
		}
		return wordsList;
	}
}
