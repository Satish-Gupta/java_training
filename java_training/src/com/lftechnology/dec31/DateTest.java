package com.lftechnology.dec31;

/**
 * Create a class called Date that includes three pieces of information as
 * instance variables a month (type int), a day (type int) and a year (type
 * int). Your class should have a constructor that initializes the three
 * instance variables and assumes that the values provided are correct. Provide
 * a set and a get method for each instance variable. Provide a method
 * displayDate that displays the month, day and year separated by forward
 * slashes (/). Write a test application named DateTest that demonstrates class
 * Date's capabilities.
 * 
 * @author satish
 *
 */
public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(1999, 5, 24);
		System.out.print("Date: ");
		date.displayDate();
	}

}

/**
 * This class stores Date which is represented by year, month and date and also
 * provide ways to print the date parts separated by /
 * 
 * @author satish
 *
 */
class Date {
	private int year = 0;
	private int month = 0;
	private int day = 0;

	/**
	 * initializes date with provided year, month and day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * changes the year of the date
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * changes the month of the date
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * changes the day of month in a date
	 * 
	 * @param day
	 *            of a month
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * displays date in day/month/year format
	 */
	public void displayDate() {
		System.out.println(day + "/" + month + "/" + year);
	}

}
