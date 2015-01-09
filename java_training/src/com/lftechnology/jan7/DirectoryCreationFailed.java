package com.lftechnology.jan7;

/**
 * signals that the attempt to create the directory has failed
 * 
 * @author satish
 * 
 */
public class DirectoryCreationFailed extends Exception {
	private static String message = "the requested directory creation failed";

	public DirectoryCreationFailed() {
	}

	DirectoryCreationFailed(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
