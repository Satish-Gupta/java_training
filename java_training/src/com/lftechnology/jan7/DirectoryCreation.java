package com.lftechnology.jan7;

import java.io.File;
import java.util.logging.Logger;

/**
 * @author satish
 * 
 */
public class DirectoryCreationIO {
	private static final Logger logger = Logger.getLogger(DirectoryCreationIO.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("/home/satish/java/myDirectory");
		boolean isDirectoryCreated = false;
		// get the index of the directory to be created;

		if (file.exists()) {
			logger.severe("The directory " + file.getName() + " already exists");
		}
		isDirectoryCreated = file.mkdir();
		if (isDirectoryCreated) {
			logger.info("Directory " + file.getName() + " created");
		} else {
			logger.severe("Directory creation failed");
		}
	}
}