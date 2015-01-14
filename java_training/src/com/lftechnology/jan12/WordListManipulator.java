package com.lftechnology.jan12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Takes the words in its argument list and prints out any duplicate words, the number of distinct words, and a list of the words with
 * duplicates eliminated. Hint: Try with HashSet and List implementation. 2. Suppose you want to know which words in the argument list occur
 * only once and which occur more than once, but you do not want any duplicates printed out repeatedly. This effect can be achieved by
 * generating two sets one containing every word in the argument list and the other containing only the duplicates. The words that occur
 * only once are the set difference of these two sets
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class WordListManipulator {
	private static final Logger LOGGER = Logger.getLogger(WordListManipulator.class.getName());

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>(Arrays.asList(args));
		Set<String> noDuplicateWords = new HashSet<String>(words);
		Set<String> duplicateWords = new HashSet<String>();
		Set<String> distinctWords = new HashSet<String>(noDuplicateWords);

		duplicateWords = retainDuplicateWords(words);
		distinctWords.removeAll(duplicateWords);

		LOGGER.log(Level.INFO, "The list of Words is: {0}", words);
		LOGGER.log(Level.INFO, "Duplicate words: {0}", duplicateWords);
		LOGGER.log(Level.INFO, "Number of distict words: {0}", distinctWords.size());
		LOGGER.log(Level.INFO, "Words after duplicates eleminated: {0}", noDuplicateWords);
	}

	/**
	 * Retains only the elements in this list which are present more than once i.e which have duplicate values. The duplicate vaules are
	 * retained only once
	 * 
	 * @param words
	 *            {@link List} of <@link String> for which only duplicated values need to be retained.
	 * @return {@link Set} containing the duplicate values from the words {@link List}
	 */
	public static Set<String> retainDuplicateWords(List<String> words) {
		Set<String> duplicateWords = new HashSet<String>();

		for (String word : words) {
			if (Collections.frequency(words, word) > 1) {
				duplicateWords.add(word);
			}
		}
		return duplicateWords;
	}
}
