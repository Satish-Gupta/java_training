package com.lftechnology.jan7;

/**
 * signals rename operation on file resource has failed.
 * 
 * @author satish
 * 
 */
public class RenameFailedException extends Exception {
	private static final long serialVersionUID = 2890375616788248737L;
	private static String message = "the requested file could not be renamed";

	public RenameFailedException() {
	}

	RenameFailedException(String messageStr) {
		message = messageStr;
	}

	@Override
	public String toString() {
		return message;
	}
}
