package com.lftechnology.jan7;

/**
 * signals that the File resource is not a directory when a directory is expected
 * 
 * @author satish
 * 
 */
public class NotADirectoryException extends Exception {
	private static String message = "the given resource is not a directory";

	public NotADirectoryException() {
	}

	NotADirectoryException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
