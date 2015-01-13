package com.lftechnology.jan12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a list of words and allows operations such as adding elements to the list,merging two word list and removing every
 * second element.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class WordList {
	private List<String> words = null;

	/**
	 * constructs <code>WordList</code>
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	WordList() {
	}

	/**
	 * constructs <code>WordList</code> with the supplied {@link List}
	 * 
	 * @param words
	 *            {@link List} which contains words for this word List
	 * @author satish<satishgupta@lftechnology.com>
	 */
	WordList(List<String> words) {
		this.words = words;
	}

	/**
	 * merges the words from the supplied wordList into this wordList
	 * 
	 * @param wordsList
	 *            the {@link WordList} which words are to be merged in this words List
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void merge(WordList wordsList) {
		this.words.addAll(wordsList.words);
	}

	/**
	 * Adds {@link String} element to this {@link WordList}
	 * 
	 * @param element
	 *            the element to be added
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void add(String element) {
		words.add(element);
	}

	/**
	 * Adds the elements of the {@link String} array to the end of this wordList.
	 * 
	 * @param elements
	 *            {@link String} array which elements will be added to the end of the list.
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void add(String[] elements) {
		words.addAll(Arrays.asList(elements));
	}

	/**
	 * Removes every second Word in this {@link WordList} i.e words at even positions.
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void removeEverySecondWord() {
		Iterator<String> iterator = words.iterator();

		for (int i = 1; i < words.size(); i++) {
			words.remove(i);
		}
	}

	/**
	 * Returns the list of word for this {@link WordList} object.
	 * 
	 * @return the list of words for this object
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public List<String> getList() {
		return words;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Word List Contents:" + words;
	}
}
