package com.lftechnology.jan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to rename the given file, after renaming the file delete the renamed file. (Accept the file name using command line
 * arguments.)
 * 
 * @author satish
 * 
 */
public class FileRenaming {
	private static final Logger LOGGER = Logger.getLogger(FileRenaming.class.getName());

	public static void main(String[] args) {
		boolean isFileRenamed = false;

		if (args.length < 2) {
			LOGGER.log(Level.SEVERE, "Usage: {0}, old_file new_file_name" + FileRenaming.class.getName());
		} else {
			String originalFilePath = args[0];
			String newFileName = args[1];
			File originalFile = new File(originalFilePath);
			File newFile = new File(newFileName);

			try {
				isFileRenamed = FileUtils.renameFile(originalFile, newFileName);
			} catch (FileNotFoundException | FileAlreadyExistsException e) {
				LOGGER.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
			}
			if (isFileRenamed) {
				LOGGER.log(Level.INFO, "File {0} Exists? {1} ", new Object[] { newFile.getAbsoluteFile(), newFile.exists() });
				try {
					FileUtils.deleteFile(newFile);
				} catch (FileNotFoundException e) {
					LOGGER.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
				}
				LOGGER.log(Level.INFO, "File {0} Exists? {1} ", new Object[] { newFile.getAbsoluteFile(), newFile.exists() });
			}
		}
	}
}
