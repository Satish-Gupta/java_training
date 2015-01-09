package com.lftechnology.jan7;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to create a directory and check whether the directory is created.
 * 
 * @author satish
 * 
 */
public class DirectoryCreation {
	private static final Logger LOGGER = Logger.getLogger(DirectoryCreation.class.getName());

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String filePath = "";
		String userHome = System.getProperty("user.home");

		if (osName.equals("Linux")) {
			filePath = userHome + "/java/myDirectory";
		} else {
			filePath = userHome + "\\java\\myDirectory";
		}

		File file = new File(filePath);
		try {
			FileUtils.createDirectory(file);
		} catch (FileAlreadyExistsException | NotADirectoryException | DirectoryCreationFailed e) {
			LOGGER.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		}

	}
}