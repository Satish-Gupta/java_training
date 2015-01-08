package com.lftechnology.jan7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Write a program to rename the given file, after renaming the file delete the renamed file. (Accept the file name using command line
 * arguments.)
 * 
 * @author satish
 * 
 */
public class FileRenameNIO {
	private static final Logger logger = Logger.getLogger(FileRenameNIO.class.getName());

	public static void main(String[] args) {
		final int ERROR_EXIT_CODE = 1;
		if (args.length < 2) {
			logger.severe("Usage:" + FileRenameNIO.class.getName() + " originalFile " + "renameFile");
			System.exit(ERROR_EXIT_CODE);
		}
		String originalFilePath = args[0];
		String newFileNameStr = args[1];

		Path originalFile = Paths.get(originalFilePath);
		Path newFileName = Paths.get(newFileNameStr);

		if (Files.notExists(originalFile)) {
			logger.severe("The given file does not exist");
			System.exit(ERROR_EXIT_CODE);
		}

		logger.info("Before Renaming, FileName: " + originalFile.getFileName());
		Path resolvedPath = originalFile.resolveSibling(newFileName);
		try {
			originalFile = Files.move(originalFile, resolvedPath);
		} catch (IOException exception) {
			logger.severe("" + exception);
		}

		logger.info("After renaming, FileName:" + originalFile.getFileName());

		try {
			Files.delete(originalFile);
		} catch (IOException exception) {
			logger.severe("" + exception);
		}
		logger.info("File Exists " + Files.exists(originalFile));
	}
}
