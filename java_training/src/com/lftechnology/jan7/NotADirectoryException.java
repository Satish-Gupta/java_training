package com.lftechnology.jan7;

/**
 * signals that the File resource is not a directory when a directory is expected
 * 
 * @author satish
 * 
 */
public class NotADirectoryException extends Exception {
	private static final long serialVersionUID = 5354192230194282790L;
	private static String message = "the given resource is not a directory";

	public NotADirectoryException() {
	}

	NotADirectoryException(String messageStr) {
		message = messageStr;
	}

	@Override
	public String toString() {
		return message;
	}
}
