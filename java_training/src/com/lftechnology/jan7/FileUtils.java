package com.lftechnology.jan7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides various utitly methods realting to file handling such as file and directory creation, renaming and deletion.
 * 
 * @author satish
 * 
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

	/**
	 * @param file
	 * @return true if the named file does not exist and was successfully created; false if the named file already exists
	 * @throws SecurityException
	 * @throws IOException
	 * @throws {@link NotAFileException}
	 */
	public static boolean createFile(File file) throws SecurityException, IOException, NotAFileException {
		boolean isFileCreated = false;
		final String NOT_A_FILE_MSG = "requested resource " + file.getAbsolutePath() + "is not a file resource";
		if (file.isDirectory()) {
			throw new NotAFileException(NOT_A_FILE_MSG);
		}
		isFileCreated = file.createNewFile();
		if (isFileCreated) {
			logger.log(Level.INFO, "file {0} Created at {1}", new Object[] { file.getName(), file.getParent() });
		} else {
			logger.log(Level.INFO, "file {0} not created since it already exists at {1}", new Object[] { file.getName(), file.getParent() });
		}
		return isFileCreated;
	}

	/**
	 * creates a directory
	 * 
	 * @param directory
	 * @return true if and only if the directory was created; false otherwise
	 * @throws {@linkNotADirectoryException}
	 * @throws {@link DirectoryCreationFailedException}
	 */
	public static boolean createDirectory(File directory) throws NotADirectoryException, DirectoryCreationFailed,
			FileAlreadyExistsException {
		boolean isDirectoryCreated = false;
		final String FILE_EXIST_MSG = "directory " + directory.getAbsolutePath() + " already exist";
		final String DIR_CREATION_FAILED =
				"requested directory " + directory.getName() + "creation at requested path" + directory.getParent() + "failed";
		if (directory.isFile()) {
			final String NOT_DIRECTOY_MSG =
					"Requested directory deletion but passed the requested resource" + directory.getAbsolutePath() + "is a file";
			throw new NotADirectoryException(NOT_DIRECTOY_MSG);
		}
		if (directory.exists()) {
			throw new FileAlreadyExistsException(FILE_EXIST_MSG);
		}
		isDirectoryCreated = directory.mkdir();
		if (isDirectoryCreated) {
			logger.log(Level.INFO, "Requested directory {0} created at {1} ", new Object[] { directory.getName(), directory.getParent() });
		} else {
			throw new DirectoryCreationFailed(DIR_CREATION_FAILED);
		}
		return isDirectoryCreated;
	}

	/**
	 * 
	 * @param oldFile
	 *            : file that is to be renamed
	 * @param newFileStr
	 *            : the new fileName or path to the old file with the new file Name at the end of the path
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws FileAlreadyExistsException
	 * @throws {@link RenameFailedException}
	 */
	public static boolean renameFile(File oldFile, String newFileStr) throws RenameFailedException, IOException {
		File newFile = new File(newFileStr);
		Path oldFilePath = oldFile.toPath();
		Path newFilePath = oldFilePath.getParent().resolve(newFileStr);

		final String FILE_NOT_fOUND_MSG = "file" + oldFile.getAbsolutePath() + "could not be found";
		final String FILE_EXIST_MSG = "file" + newFile.getAbsolutePath() + " already exist";
		final String FILE_RENAME_FAILED_MSG =
				"file " + oldFile.getAbsolutePath() + "could not be renamed since file with new Name " + newFile.getName()
						+ "exist at that path";
		if (!oldFile.exists()) {
			throw new FileNotFoundException(FILE_NOT_fOUND_MSG);
		}
		if (Files.exists(newFilePath)) {
			throw new FileAlreadyExistsException(FILE_EXIST_MSG);
		}

		logger.log(Level.INFO, "Renaming, File {0} to {1} ", new Object[] { oldFile.getAbsolutePath(), newFile.getAbsolutePath() });
		Path renamedFile = Files.move(oldFilePath, newFilePath);
		if (Files.exists(renamedFile)) {
			logger.log(Level.INFO, "File {0} renamed to {1}: ", new Object[] { oldFile.getAbsolutePath(), newFile.getAbsoluteFile() });
			return true;
		} else {
			throw new RenameFailedException(FILE_RENAME_FAILED_MSG);
		}
	}

	/**
	 * @param file
	 *            : file to be deleted
	 * @return true if and only if the file or directory is successfully deleted; false otherwise
	 * @throws FileNotFoundException
	 */
	public static boolean deleteFile(File file) throws FileNotFoundException {
		final String FILE_NOT_fOUND_MSG = "deletion of file" + file.getAbsolutePath() + "failed because it could not be found";
		logger.log(Level.INFO, "deleting file {0}", file.getAbsolutePath());
		boolean isDeleted = false;
		if (file.exists()) {
			isDeleted = file.delete();
			logger.log(Level.INFO, "file {0} deleted", file.getAbsolutePath());
		} else {
			throw new FileNotFoundException(FILE_NOT_fOUND_MSG);
		}
		return isDeleted;
	}

	/**
	 * @param file
	 *            : file which content is being read.
	 * @return List of Objects whose individual element may be an Integer Object,Float Object or a String Object read from the file
	 * @throws FileNotFoundException
	 */
	public static List<Object> readFile(File file) throws FileNotFoundException {
		List<Object> fileContents = new ArrayList<Object>();
		final String FILE_NOT_fOUND_MSG = "file" + file.getAbsolutePath() + "cannot be read because it could not be found";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(file)));
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					fileContents.add(scanner.nextInt());
				} else if (scanner.hasNextDouble()) {
					fileContents.add(scanner.nextFloat());
				} else if (scanner.hasNext()) {
					fileContents.add(scanner.next());
				}
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
			throw new FileNotFoundException(FILE_NOT_fOUND_MSG);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return fileContents;
	}
}
