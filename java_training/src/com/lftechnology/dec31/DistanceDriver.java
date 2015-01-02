package com.lftechnology.dec31;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2. Create a class called Distance that includes two private data members feet
 * (type int) and inches (type float). Use a method setData to set values to
 * instance variables. Provide a method display that displays the feet and
 * inches, a member function addDistance for adding two distances, and a member
 * function compareDistance for comparing two distances. Implement your program
 * in Java.
 * 
 * @author satish
 *
 */
public class DistanceDriver {
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int feet = 0;
		float inches = 0;

		System.out.println("Enter the data for distance1");
		feet = getFeetInput();
		inches = getInchesInput();
		Distance distance1 = new Distance();
		Distance distance2 = new Distance();
		try {

			distance1.setData(feet, inches);
			distance1.display();

			System.out.println("\nEnter the data for distance2");
			feet = getFeetInput();
			inches = getInchesInput();

			distance2.setData(feet, inches);
			distance2.display();
		} finally {
			scanner.close();
		}
		System.out.println("\nAdding two distances:");
		Distance resultantDistance = distance1.addDistance(distance2);

		distance1.display();
		System.out.print(" + ");
		distance2.display();
		System.out.print(" = ");
		resultantDistance.display();

		System.out.println("Comparing two distances");
		int compareResult = distance1.compareDistance(distance2);

		if (compareResult == 1) {
			System.out.println("Distance 1 is greater than distance 2");
		} else if (compareResult == -1) {
			System.out.println("Distance 1 is smaller than distance 2");
		} else if (compareResult == 0) {
			System.out.println("Distance 1 and Distance 2 are equal");
		}

	}

	/**
	 * get feet value of a distance from the user. If the value entered is non
	 * numerical then input mismatch exception occurs which handled by giving
	 * appropriate message and asking the user to give expected input and if
	 * negative numerical the appropriate message is displayed and the user is
	 * asked to enter the expected input
	 * 
	 * @return distance value in terms of feets
	 * 
	 */
	public static int getFeetInput() {
		System.out.println("Enter distance(positive number) in feet");
		int feet = 0;
		boolean isInputValid = true;
		do {
			try {
				// reset isInputValid to true for every iteration
				isInputValid = true;
				feet = scanner.nextInt();
				if (feet < 0) {
					System.out
							.println("Wrong input. Please enter a positive numerical value.");

					isInputValid = false;
				}
			} catch (InputMismatchException exception) {
				System.out
						.println("Wrong input. Please enter a positive numerical value.");
				scanner.nextLine();
				isInputValid = false;
			}
		} while (!isInputValid);

		return feet;
	}

	/**
	 * get feet value of a distance from the user. If the value entered is non
	 * numerical then input mismatch exception occurs which handled by giving
	 * appropriate message and asking the user to give expected input and if
	 * negative numerical or numerical greater tha 11 is entered then
	 * appropriate message is displayed and the user is asked to enter the input
	 * in correct format.
	 * 
	 * @return
	 */
	public static float getInchesInput() {
		System.out.println("Enter distance(positive number) in inches");
		float inches = 0;
		boolean isInputValid = true;
		do {
			try {
				// reset isInputValid to true for every iteration
				isInputValid = true;
				inches = scanner.nextFloat();
				if (inches < 0) {
					System.out
							.println("Wrong input. Please enter a positive numerical value.");

					isInputValid = false;
				} else if (inches > 11) {
					isInputValid = false;
					System.out.print("Please enter value less than 12");
				}
			} catch (InputMismatchException exception) {
				System.out
						.println("Wrong input. Please enter a positive numerical value.");
				scanner.nextLine();
				isInputValid = false;
			}
		} while (!isInputValid);

		return inches;
	}

}

/**
 * This class represents distance in terms of feet and inches, allows you to add
 * and compare two distances
 * 
 * @author satish
 *
 */
class Distance {
	private int feet = 0;
	private float inches = 0;

	public void setData(int feet, float inches) {
		this.feet = feet;
		this.inches = inches;
	}

	/**
	 * @return feet value of distance
	 */
	public int getFeet() {
		return feet;
	}

	/**
	 * @return inches value of distance
	 */
	public float getInches() {
		return inches;
	}

	/**
	 * dispalys feet value and inches value of distance
	 */
	public void display() {
		System.out.println(feet + " feet" + inches + "inches");
	}

	// converts feet and inches value into inches only and returns the same
	/**
	 * @return inches equivalent to distance represented by feets and inches.
	 */
	public float getInInches() {
		return feet * 12 + inches;
	}

	/**
	 * add two distances represented in feets and inches and returns the result
	 * as a distance represented in feet and inches
	 * 
	 * @param distance
	 * @return
	 */
	public Distance addDistance(Distance distance) {
		float inchesSum = this.getInInches() + distance.getInInches();
		int feet = (int) inchesSum / 12;
		float inches = inchesSum % 12;

		Distance resultantDistance = new Distance();
		resultantDistance.setData(feet, inches);

		return resultantDistance;
	}

	/**
	 * compares two distance represented in feets and inches
	 * 
	 * @param distance
	 *            to be compared with the invoking objec
	 * @return comparision result - 0 if equal, -1 if invoking object distance
	 *         is less and 1 if the invoking object is greater
	 */
	public int compareDistance(Distance distance) {
		float distance1Inches = this.getInInches();
		float distance2Inches = distance.getInInches();
		if (distance1Inches < distance2Inches) {
			return -1;
		} else if (distance1Inches > distance2Inches) {
			return 1;
		} else {
			return 0;
		}
	}

}
