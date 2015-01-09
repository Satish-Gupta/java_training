package com.lftechnology.jan7;

/**
 * signals that the attempt to create the directory has failed
 * 
 * @author satish
 * 
 */
public class DirectoryCreationFailed extends Exception {
	private static final long serialVersionUID = -1713870792059119784L;
	private static String message = "the requested directory creation failed";

	public DirectoryCreationFailed() {
	}

	DirectoryCreationFailed(String messageStr) {
		message = messageStr;
	}

	@Override
	public String toString() {
		return message;
	}
}
