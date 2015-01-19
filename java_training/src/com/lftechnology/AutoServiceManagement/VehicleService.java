package com.lftechnology.AutoServiceManagement;

/**
 * This class represents services which can be provided for different vehicles.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class VehicleService {
	private String name = "";
	private float price = 0;

	// To do create a class time or use millis or use the Time class made in previous assignment

	/**
	 * constructs {@link VehicleService}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public VehicleService() {

	}

	/**
	 * constructs {@link VehicleService} with the supplied name and price.
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public VehicleService(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Sets the name for this {@link VehicleService}
	 * 
	 * @param name
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the name for this {@link VehicleService}
	 * 
	 * @param name
	 *            the name for this {@lin VehicleService}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the price for this {@link VehicleService}
	 * 
	 * @param price
	 *            the price to be charged for this {@link VehicleService}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Retrieves the prices for this {@link VehicleService}
	 * 
	 * @return the price to be charged for this {@link VehicleService}
	 * @author satish<satishgupta@lftechnology.com>
	 * 
	 */
	public float getPrice() {
		return price;
	}

}
