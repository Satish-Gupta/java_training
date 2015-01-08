package com.lftechnology.jan7;

import java.io.File;
import java.util.logging.Logger;

/**
 * @author satish
 * 
 */
public class FileRenameIO {
	private static final Logger logger = Logger.getLogger(FileRenameNIO.class.getName());

	public static void main(String[] args) {
		final int ERROR_EXIT_CODE = 0;
		boolean isRenamed = false;
		if (args.length < 2) {
			logger.severe("Usage:" + FileRenameNIO.class.getName() + " originalFile " + "renameFile");
			System.exit(ERROR_EXIT_CODE);
		}
		String originalFilePath = args[0];
		String newFileNameStr = args[1];
		System.out.println(newFileNameStr);
		File originalFile = new File(originalFilePath);
		File newFile = new File(newFileNameStr);

		if (!originalFile.exists()) {
			logger.severe("The given file does not exist");
			System.exit(ERROR_EXIT_CODE);
		}

		logger.info("Before Renaming, FileName: " + originalFile.getName());
		isRenamed = originalFile.renameTo(newFile);
		if (isRenamed) {
			logger.info("After renaming, FileName:" + newFile.getName());
		} else {
			logger.severe("file rename failed");
		}
		newFile.delete();
		logger.info("File Exists " + originalFile.exists());
	}

}
