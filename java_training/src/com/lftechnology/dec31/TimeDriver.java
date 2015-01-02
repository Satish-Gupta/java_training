package com.lftechnology.dec31;

/**
 * 4. Create a class called Time with three attributes hours, minutes, and
 * seconds. Use appropriate constructor (s) to initialize instance variables.
 * Also, use a display method to display the time in hh:mm:ss format. Modify the
 * class to add two time objects that correctly results in addition of times.
 * 
 * @author satish
 *
 */
public class TimeDriver {

	public static void main(String[] args) {
		Time time1 = new Time(1, 20, 30);
		Time time2 = new Time(2, 50, 40);

		System.out.println("Time1:");
		time1.display();
		System.out.println("Time2:");
		time2.display();

		Time resultantTime = time1.addTime(time2);
		System.out.println("Time1 + Time2 = ");
		resultantTime.display();
	}
}

/**
 * This class holds data to represent time in the form of hour, minutes and
 * seconds and also can add two time objects.
 * 
 * @author satish
 *
 */
class Time {
	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	Time() {
	}

	Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * displays the time hh:mm:ss format
	 */
	public void display() {
		System.out.println(hours + ":" + minutes + ":" + seconds);
	}

	/**
	 * adds two time objects
	 * 
	 * @param time
	 *            the time object that will be added to this time object
	 * 
	 * @return the resultant time after addig two time objects
	 */
	public Time addTime(Time time) {

		int seconds = this.seconds + time.seconds;
		int minutes = this.minutes + time.minutes;
		minutes += seconds / 60;
		seconds %= 60;
		int hours = this.hours + time.hours;
		hours += minutes / 60;
		minutes %= 60;

		return new Time(hours, minutes, seconds);

	}
}
