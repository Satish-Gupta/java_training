package com.lftechnology.jan12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class WordsShuffle {
	private static Logger LOGGER = Logger.getLogger(WordsShuffle.class.getName());

	public static void main(String[] args) {
		List<String> words = Arrays.asList(args);

		LOGGER.log(Level.INFO, "The words are:{0}", words);
		Collections.shuffle(words);
		LOGGER.log(Level.INFO, "words after Shuffle operation:{0}", words);

	}
}
