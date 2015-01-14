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
	private int totalPrice = 0;
	// to do check possible use of Set
	List<Service> items = new ArrayList<Service>();

	/**
	 * constructs <code>Bill</code>
	 * 
	 * @author satish
	 */
	public Bill() {
	}

	/**
	 * constructs <code>Bill</code> with for the provided {@link List} of {@link Service}
	 * 
	 * @author satish
	 */
	public Bill(List<Service> items) {
		this.items = items;
	}

	/**
	 * Calculates the total amount for the items in this {@link Bill}
	 * 
	 * @return total amount for this {@link Bill}
	 * @author satish
	 */
	public int calculateTotal() {
		for (Service service : items) {
			totalPrice += service.getPrice();
		}
		return totalPrice;
	}

	/**
	 * Adds {@link Service} item in this {@link Bill}
	 * 
	 * @param service
	 *            {@link Service} being charged for in this {@link Bill}
	 * @author satish
	 */
	public void addItem(Service service) {
		items.add(service);
	}

	/**
	 * Retrives the total amound for this {@link Bill}
	 * 
	 * @return total amount for this bill
	 * @author satish
	 */
	public int getTotal() {
		return totalPrice;
	}

	/**
	 * Clears the bill amount
	 * 
	 * @author satish
	 */
	public void clear() {
		totalPrice = 0;
	}
}
