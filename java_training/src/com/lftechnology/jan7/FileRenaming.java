package com.lftechnology.jan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author satish
 * 
 */
public class FileRenaming {
	private static final Logger logger = Logger.getLogger(FileRenaming.class.getName());

	public static void main(String[] args) {
		final int EXIT_ERROR_CODE = 0;
		if (args.length < 2) {
			logger.log(Level.SEVERE, "Usage: {0}, old_file new_file_name" + FileRenaming.class.getName());
			System.exit(EXIT_ERROR_CODE);
		}
		boolean isFileRenamed = false;
		String originalFilePath = args[0];
		String newFileName = args[1];

		File originalFile = new File(originalFilePath);
		File newFile = new File(newFileName);
		try {
			isFileRenamed = FileUtils.renameFile(originalFile, newFileName);
		} catch (FileNotFoundException | FileAlreadyExistsException e) {
			logger.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		} catch (Exception e) {
			logger.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		}
		if (isFileRenamed) {
			logger.log(Level.INFO, "File {0} Exists? {1} ", new Object[] { newFile.getAbsoluteFile(), newFile.exists() });
			try {
				FileUtils.deleteFile(newFile);
			} catch (FileNotFoundException e) {
				logger.log(Level.SEVERE, "{0}, at class {1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
			}
			logger.log(Level.INFO, "File {0} Exists? {1} ", new Object[] { newFile.getAbsoluteFile(), newFile.exists() });
		}
	}
}
