package com.lftechnology.AutoServiceManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the data of the {@link Vehicle} being serviced at {@link AutoCenter} for a {@link List} of {@link VehicleService} and
 * the {@link Bill} which holds the charges for those services.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class ServiceTicket {
	private Vehicle vehicle = null;
	private List<VehicleService> servicesRequested = new ArrayList<VehicleService>();;
	private Bill bill = null;

	/**
	 * Constructs {@link ServiceTicket}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public ServiceTicket() {
	}

	/**
	 * Constructs {@link ServiceTicket} for the {@link Vehicle}
	 * 
	 * @param vehicle
	 *            {@link Vehicle} for which this service ticket is.
	 */
	public ServiceTicket(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Sets the {@link Vehicle} for this {@link ServiceTicket}.
	 * 
	 * @param vehicle
	 *            {@link Vehicle} for which the {@link ServiceTicket} belongs
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Retrieves the {@link Vehicle} for this {@link ServiceTicket}
	 * 
	 * @return {@link Vehicle} of this {@link ServiceTicket}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Adds the {@link VehicleService} to this {@link ServiceTicket}.
	 * 
	 * @param service
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void addService(VehicleService service) {
		servicesRequested.add(service);
	}

	/**
	 * Removes the {@link VehicleService} to this {@link ServiceTicket}.
	 * 
	 * @param service
	 *            {@link VehicleService} to be removed
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void removeService(VehicleService service) {
		servicesRequested.remove(service);
	}

	/**
	 * Sets the {@link List} of {@link VehicleService} for this {@link ServiceTicket}
	 * 
	 * @param services
	 *            the {@link List} of {@link VehicleService} for the {@link Vehicle} of this {@link ServiceTicket}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setServicesRequested(List<VehicleService> services) {
		this.servicesRequested = services;
	}

	/**
	 * Retrieves the {@link List} of {@link VehicleService} for this {@link ServiceTicket}
	 * 
	 * @return {@link List} of {@link VehicleService}s for this {@link ServiceTicket}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public List<VehicleService> getServicesRequested() {
		return servicesRequested;
	}

	/**
	 * Sets the {@link Bill} that represents the charges for the {@link List} of {@link VehicleService} for this {@link ServiceTicket}
	 * 
	 * @param bill
	 *            the {@link Bill} to be set for this {@link ServiceTicket}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * Retrieves {@link Bill} of this {@link ServiceTicket} which holds the chareges for the Services in this ticket.
	 * 
	 * @return {@link Bill}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Bill getBill() {
		return bill;
	}
}
