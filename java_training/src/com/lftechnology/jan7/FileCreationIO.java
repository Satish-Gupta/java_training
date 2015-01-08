package com.lftechnology.jan7;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Write a program to create a text file in the path c:\java\abc.txt and check whether that file is exists. Using the command exists(),
 * isDirectory(), isFile(), getName() and getAbsolutePath().
 * 
 * @author satish
 * 
 */
public class FileCreationIO {
	private static final Logger logger = Logger.getLogger(FileCreationNIO.class.getName());

	public static void main(String[] args) {
		File file = new File("/home/satish/java/abc1.txt");
		boolean fileCreationStatus = false;
		try {
			fileCreationStatus = file.createNewFile();
			if (fileCreationStatus) {
				logger.info("File created with the given name" + file.getName());
			} else {
				logger.severe("File:" + file.getName() + " not created since it already exists");
			}
		} catch (IOException exception) {
			logger.severe("" + exception);
		}
		logger.info("" + file.getAbsolutePath() + ":" + "exists-" + file.exists() + ", isDirectory-" + file.isDirectory() + ", isFile-"
				+ file.isFile() + ", Name-" + file.getName() + ",  AbsolutePath-" + file.getAbsolutePath());
	}
}
