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
public class AutoMobileServiceManagement {
	private final static Logger LOGGER = Logger.getLogger(AutoMobileServiceManagement.class.getName());

	public static void main(String[] args) {
		final VehicleService wash = new VehicleService("wash", 200);
		final VehicleService wax = new VehicleService("wax", 50);
		final VehicleService color = new VehicleService("color", 5000);
		Car car = new Car(1111L);
		List<VehicleService> servicesRequested = new ArrayList<VehicleService>();

		LOGGER.log(Level.INFO, "requesting services wash and color for {0}", car);
		// request services for the car
		servicesRequested.add(wash);
		servicesRequested.add(color);

		Bill bill = new Bill(servicesRequested);
		bill.calculateTotal();

		LOGGER.log(Level.INFO, "Total bill amount for the {0} is {1}", new Object[] { car, bill.getTotal() });
		LOGGER.log(Level.INFO, "Performing requested Services for {0}", car);
		for (VehicleService service : servicesRequested) {
			if (service.equals(wash)) {
				wash(car);
			} else if (service.equals(wax)) {
				polish(car);
			} else {
				paint(car);
			}
		}
		LOGGER.log(Level.INFO, "servicing for {0} completed", car);
		LOGGER.log(Level.INFO, "Clearing the bill");
		bill.clear();
		LOGGER.log(Level.INFO, "Bill Status of {0} : {1}", new Object[] { car, bill.isCleared() ? "cleared" : "pending" });
	}

	/**
	 * Performs wash operation on object of {@link Car}
	 * 
	 * @param {@link Car} to be washed
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public static void wash(Car car) {
		LOGGER.info("washing " + car);
	}

	/**
	 * Performs polish operation on object of {@link Car}
	 * 
	 * @param {@link Car} to be polished with wax
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public static void polish(Car car) {
		LOGGER.info("polishing " + car);
	}

	/**
	 * Performs paint operation on object of {@link Car}
	 * 
	 * @param {@link Car} to be painted
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public static void paint(Car car) {
		LOGGER.info("painting" + car);
	}
}
