package com.lftechnology.jan7;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to create a directory and check whether the directory is created.
 * 
 * @author satish
 * 
 */
public class DirectoryCreation {
	private static final Logger logger = Logger.getLogger(DirectoryCreation.class.getName());

	public static void main(String[] args) {
		File file = new File("/home/satish/java/myDirectory");

		try {
			FileUtils.createDirectory(file);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		}

	}
}