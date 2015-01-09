package com.lftechnology.jan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program called FileInput to read an int, a double, and a String form a text file called "in.txt", and produce the following
 * output: (Hint use Scanner to read from file)
 * 
 * <ul>
 * <li>a. The integer read is 12</li>
 * <li>b. The floating point number read is 33.44</li>
 * <li>c. The String read is "Peter"</li>
 * <li>d. Hi! Peter, the sum of 12 and 33.44 is 45.44</li>
 * <ul>
 * 
 * @author satish
 * 
 */
public class FileInput {
	private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String filePath = "";
		String userHome = System.getProperty("user.home");
		if (osName.equals("Linux")) {
			filePath = userHome + "/java/myDirectory/in.txt";
		} else {
			filePath = userHome + "\\java\\myDirectory\\in.txt";
		}
		File file = new File(filePath);
		List<Object> contents = new ArrayList<Object>();
		List<Integer> intValues = new ArrayList<Integer>();
		List<Float> floatValues = new ArrayList<Float>();
		List<String> stringValues = new ArrayList<String>();
		float sum = 0;

		try {
			contents = FileUtils.readFile(file);
			// read the items in contents and group them accoding to their types
			for (Object element : contents) {
				if (element instanceof Integer) {
					intValues.add((Integer) element);
				} else if (element instanceof Float) {
					floatValues.add((Float) element);
				} else if (element instanceof String) {
					stringValues.add((String) element);
				}
			}

			// for holding all the int values in a single String
			StringBuilder intValueStrBuilder = new StringBuilder();
			for (Integer value : intValues) {
				intValueStrBuilder.append(value + " ");
				sum += value;
			}
			logger.log(Level.INFO, "The integer read are {0}", intValueStrBuilder);

			// for holding all the float values in a single String
			StringBuilder floatValuesStrBuilder = new StringBuilder();
			for (Float value : floatValues) {
				floatValuesStrBuilder.append(value + " ");
				sum += value;
			}
			logger.log(Level.INFO, "The floating point number read are {0}", floatValuesStrBuilder);

			StringBuilder stringBuilder = new StringBuilder();
			for (String value : stringValues) {
				stringBuilder.append(value + ", ");
			}
			logger.log(Level.INFO, "The string read are {0}", stringBuilder);
			logger.log(Level.INFO, "Hi! {0} the sum of {1} {2} is {3}", new Object[] { stringBuilder, intValueStrBuilder,
					floatValuesStrBuilder, sum });
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Exception:{0} class:{1}, cause:{2}", new Object[] { e.getMessage(), e.getClass(), e.getCause() });
		}

	}
}
