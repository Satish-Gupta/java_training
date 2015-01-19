package com.lftechnology.AutoServiceManagement;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<VehicleService> services = new ArrayList<VehicleService>();
		services.add(AutoMobileServiceConstants.WASH);
		services.add(AutoMobileServiceConstants.POLISH);
		services.add(AutoMobileServiceConstants.PAINT);
		AutoCenter autoCenter = new AutoCenter("Mahalaxmi auto Center", services);
		Vehicle vehicle = new Car(1111L);

		LOGGER.log(Level.INFO, "requesting services wash and paint for {0}", vehicle);
		// request service wash and paint and get the Bill for those requested Services
		Bill bill =
				autoCenter.requestService(vehicle,
						new ArrayList<VehicleService>(Arrays.asList(AutoMobileServiceConstants.WASH, AutoMobileServiceConstants.PAINT)));

		LOGGER.log(Level.INFO, "Total bill amount for the {0} is {1}", new Object[] { vehicle, bill.getTotal() });
		LOGGER.log(Level.INFO, "Performing requested Services for {0}", vehicle);
		autoCenter.processServiceQueue();
		LOGGER.log(Level.INFO, "servicing for {0} completed", vehicle);
		LOGGER.log(Level.INFO, "Clearing the bill");
		bill.clear();
		LOGGER.log(Level.INFO, "Bill Status of {0} : {1}", new Object[] { vehicle, bill.isCleared() ? "cleared" : "pending" });
	}
}
