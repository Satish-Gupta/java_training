package com.lftechnology.jan7;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Write a program to create a text file in the path c:\java\abc.txt and check whether that file is exists. Using the command exists(),
 * isDirectory(), isFile(), getName() and getAbsolutePath().
 * 
 * @author satish
 * 
 */
public class FileCreationNIO {
	private static final Logger logger = Logger.getLogger(FileCreationNIO.class.getName());

	public static void main(String[] args) {
		Path file = Paths.get("/home/satish/java/abc.txt");
		boolean fileExists = Files.exists(file);
		logger.info("File exists:" + fileExists);

		try {
			logger.info("Creating file");
			Files.createFile(file);
		} catch (FileAlreadyExistsException x) {
			System.err.format("file named %s" + " already exists%n", file);
		} catch (IOException exception) {
			logger.severe("" + exception);
		}
		fileExists = Files.exists(file);
		logger.info("File exists:" + fileExists);
		logger.info("isDirectory:" + Files.isDirectory(file));
		logger.info("is File:" + Files.isRegularFile(file));
		logger.info("fleName:" + file.getFileName());
		logger.info("absolutePath:" + file.toAbsolutePath());
	}

}
