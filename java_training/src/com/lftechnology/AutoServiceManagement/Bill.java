package com.lftechnology.AutoServiceManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a bill which hold the items for which the billing is done.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class Bill {
	private float totalPrice = 0;
	private List<VehicleService> items = new ArrayList<VehicleService>();
	private boolean isCleared = false;

	/**
	 * constructs {@link Bill}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Bill() {
	}

	/**
	 * constructs {@link Bill} with for the provided {@link List} of {@link VehicleService}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Bill(List<VehicleService> items) {
		this.items = items;
		calculateTotal();
	}

	/**
	 * Calculates the total amount for the items in this {@link Bill}
	 * 
	 * @return total amount for this {@link Bill}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public float calculateTotal() {
		totalPrice = 0;
		for (VehicleService service : items) {
			totalPrice += service.getPrice();
		}
		return totalPrice;
	}

	/**
	 * Adds {@link VehicleService} item in this {@link Bill}
	 * 
	 * @param service
	 *            {@link VehicleService} being charged for in this {@link Bill}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void addItem(VehicleService service) {
		items.add(service);
	}

	/**
	 * Retrieves the total amount for this {@link Bill}
	 * 
	 * @return total amount for this bill
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public float getTotal() {
		return totalPrice;
	}

	/**
	 * Clears the {@link Bill}. i.e mark this {@link Bill} as paid
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void clear() {
		isCleared = true;
	}

	/**
	 * Checks if the {@link Bill} is cleared i.e if {@link Bill} has been paid
	 * 
	 * @return <code>true</code> if the bill is cleared; otherwise <code>false</code>
	 */
	public boolean isCleared() {
		return isCleared;
	}
}
