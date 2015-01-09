package com.lftechnology.jan7;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to create a text file in the path c:\java\abc.txt and check whether that file is exists. Using the command exists(),
 * isDirectory(), isFile(), getName() and getAbsolutePath().
 * 
 * @author satish
 * 
 */
public class FileCreation {
	private static final Logger logger = Logger.getLogger(FileCreation.class.getName());

	public static void main(String[] args) {
		String filePath = "/home/satish/java/abc.txt";
		File file = new File(filePath);
		try {
			FileUtils.createFile(file);
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		}
		logger.log(Level.INFO, "file-{0}: exists-{1}, isDirectory-{2}, isFile-{3}, fileName-{3}", new Object[] { file.getAbsolutePath(),
				file.exists(), file.isDirectory(), file.isFile(), file.getAbsolutePath() });
	}
}
