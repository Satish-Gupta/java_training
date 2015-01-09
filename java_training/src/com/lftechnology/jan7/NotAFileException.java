package com.lftechnology.jan7;

/**
 * signals that the requested file resource is not a file
 * 
 * @author satish
 * 
 */
public class NotAFileException extends Exception {

	private static final long serialVersionUID = 1L;
	private static String message = "the requested resource is not a file";

	public NotAFileException() {
	}

	NotAFileException(String messageStr) {
		message = messageStr;
	}

	@Override
	public String toString() {
		return message;
	}
}
