package com.lftechnology.AutoServiceManagement;

/**
 * This class represents generic services which can be used in general.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class Service {
	public String name = "";
	public int price = 0;

	// To do create a class time or use millis or use the Time class made in previous assignment

	/**
	 * constructs <code>Service</code>
	 * 
	 * @author satish
	 */
	public Service() {

	}

	/**
	 * constructs <code>Service</code> with the supplied name and price.
	 * 
	 * @author satish
	 */
	public Service(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Sets the name for this <code>Service</code>
	 * 
	 * @param name
	 * @author satish
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the name for this <code>Service</code>
	 * 
	 * @param name
	 *            the name for this <code>Service</code>
	 * @author satish
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the price for this <code>Service</code>
	 * 
	 * @param price
	 *            the price to be charged for this <code>Service</code>
	 * @author satish
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Retrieves the prices for this <code>Service</code>
	 * 
	 * @return the price to be charged for this <code>Service</code>
	 * @author satish
	 * 
	 */
	public int getPrice() {
		return price;
	}

}
