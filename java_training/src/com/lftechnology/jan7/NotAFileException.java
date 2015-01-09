package com.lftechnology.jan7;

/**
 * signals that the requested file resource is not a file
 * 
 * @author satish
 * 
 */
public class NotAFileException extends Exception {
	private static String message = "the requested resource is not a file";

	public NotAFileException() {
	}

	NotAFileException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
