package com.lftechnology.jan7;

/**
 * signals rename operation on file resource has failed.
 * 
 * @author satish
 * 
 */
public class RenameFailedException extends Exception {
	private static String message = "the requested file could not be renamed";

	public RenameFailedException() {
	}

	RenameFailedException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
