package com.lftechnology.AutoServiceManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class simulates a car being serviced at an auto center where it initiates the service operation for a car, generates the bill for
 * the service taken and after the completion of the operation clears the bill.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class AutoServiceManagement {
	private final static Logger LOGGER = Logger.getLogger(AutoServiceManagement.class.getName());

	public static void main(String[] args) {
		Service wash = new Service("wash", 200);
		Service wax = new Service("wax", 50);
		Service color = new Service("color", 5000);
		Car car = new Car(1111L);
		List<Service> servicesRequested = new ArrayList<Service>();

		LOGGER.info("requesting services wash and color for car");
		// request services for the car
		servicesRequested.add(wash);
		servicesRequested.add(color);

		Bill bill = new Bill(servicesRequested);
		bill.calculateTotal();

		LOGGER.log(Level.INFO, "Total bill amount for this car = {0}", bill.getTotal());
		LOGGER.log(Level.INFO, "Performing requested Services");
		for (Service service : servicesRequested) {
			if (service.equals(wash)) {
				car.wash();
			} else if (service.equals(wax)) {
				car.wax();
			} else {
				car.color();
			}
		}
		LOGGER.log(Level.INFO, "Car servicing completed");
		LOGGER.log(Level.INFO, "Clearing the bill");
		bill.clear();
		LOGGER.log(Level.INFO, "Total bill amount for this car = {0}", bill.getTotal());
	}
}
