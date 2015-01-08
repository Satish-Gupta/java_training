package com.lftechnology.jan7;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * @author satish
 * 
 */
public class DirectoryCreationNIO {
	private static final Logger logger = Logger.getLogger(FileCreationNIO.class.getName());

	public static void main(String[] args) {
		Path file = Paths.get("/home/satish/java/newDirectory");

		// get the index of the directory to be created;
		int newDirectoryIndex = file.getNameCount() - 1;

		if (Files.exists(file)) {
			logger.severe("The directory" + file.getName(file.getNameCount() - 1) + " already exists");
		}
		try {
			Files.createDirectories(file);

			// if creating a file or directory and a file of that name already exists.
		} catch (FileAlreadyExistsException exception) {
			logger.severe("" + exception);
		} catch (IOException exception) {
			logger.severe("" + exception);
		}
	}

}
