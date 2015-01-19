package com.lftechnology.AutoServiceManagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * This class represent {@link AutoCenter} which provides various {@link VehicleService}s to {@link Vehicle}s
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class AutoCenter {
	private final static Logger LOGGER = Logger.getLogger(AutoCenter.class.getName());
	private String name = "";
	private List<VehicleService> servicesOffered = new ArrayList<VehicleService>();
	private Queue<ServiceTicket> serviceQueue = new LinkedList<ServiceTicket>();

	/**
	 * constructs {@link AutoCenter}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public AutoCenter() {

	}

	/**
	 * constructs {@link AutoCenter}
	 * 
	 * @param name
	 *            the name of the <@link AutoCenter>
	 * @param services
	 *            the {@link List} of {@link Service} that this {@link AutoCenter} offers
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public AutoCenter(String name, List<VehicleService> services) {
		this.name = name;
		this.servicesOffered = services;
	}

	/**
	 * Sets the name of this {@link AutoCenter}
	 * 
	 * @param name
	 *            the name to be set for the {@link AutoCenter}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the {@link String} name of this {@link AutoCenter}
	 * 
	 * @return {@link String} name of this {@link AutoCenter}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the {@link List} of {@link VehicleService}s offered by this {@link AutoCenter}
	 * 
	 * @param services
	 *            the {@link List} of {@link VehicleService}s
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void setServices(List<VehicleService> services) {
		this.servicesOffered = services;
	}

	/**
	 * Retrieves the {@link List} of {@link VehicleService}s offered by this {@link AutoCenter}
	 * 
	 * @return the {@link List} of {@link VehicleService}s
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public List<VehicleService> getServices() {
		return servicesOffered;
	}

	/**
	 * Adds a new {@link VehicleService} to the {@link List} of {@link VehicleService}s offered by this {@link AutoCenter}
	 * 
	 * @param service
	 *            the {@link VehicleService} to be added to the {@link List} of the {@link VehicleServices}s offered by this
	 *            {@link AutoCenter}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void addService(VehicleService service) {
		servicesOffered.add(service);
	}

	/**
	 * Removes {@link VehicleService} from the {@link List} of {@link VehicleService}s offered by this {@link AutoCenter}
	 * 
	 * @param service
	 *            the {@link VehicleService} to be removed from the {@link List} of the {@link VehicleServices}s offered by this
	 *            {@link AutoCenter}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void removeService(VehicleService service) {
		servicesOffered.remove(service);
	}

	/**
	 * Assigns {@link List} of {@link VehicleService}s to be provided for the {@link Vehicle} and also generates {@link Bill} for the
	 * requested services.
	 * 
	 * @param vehicle
	 *            {@link Vehicle} for which the services are to be provided
	 * @param services
	 *            {@link List} of {@link VehicleServices} to be provided
	 * @return {@link Bill} for the charges of {@list List} of {@link VehicleService}
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Bill requestService(Vehicle vehicle, List<VehicleService> services) {
		ServiceTicket serviceTicket = new ServiceTicket();
		serviceTicket.setVehicle(vehicle);
		serviceTicket.setServicesRequested(services);
		serviceTicket.setBill(generateBill(services));
		serviceQueue.add(serviceTicket);
		return serviceTicket.getBill();
	}

	/**
	 * Adds the {@link ServiceTicket} to the {@link Queue} of {@link ServiceTicket} that the {@link AutoCenter} needs to act on.
	 * 
	 * @param serviceTicket
	 *            {@link ServiceTicket} which holds the servicing related details such as {@link List} of {@link VehicleService}s requested
	 *            and {@link Bill} for the same
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void addServiceTicket(ServiceTicket serviceTicket) {
		serviceQueue.add(serviceTicket);
	}

	/**
	 * To remove {@link ServiceTicket} from the {@link Queue} of {@link ServiceTicket} that {@link AutoCenter} needs to act on.
	 * 
	 * @param serviceTicket
	 *            {@link ServiceTicket} to be removed.
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void clearServiceTicket(ServiceTicket serviceTicket) {
		serviceQueue.remove(serviceTicket);
	}

	/**
	 * Generates {@link Bill} for the {@link List} of {@link VehicleService} requested.
	 * 
	 * @param services
	 *            {@link List} of {@link VehicleService} for which the {@link Bill} is to be generated
	 * @return {@link Bill} generated for the charges of the {@link List} of {@link VehicleService}s
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Bill generateBill(List<VehicleService> services) {
		return new Bill(services);
	}

	/**
	 * Performs wash operation on {@link Vehicle}
	 * 
	 * @param {@link Vehicle} to be washed
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void wash(Vehicle vehicle) {
		LOGGER.info("washing " + vehicle);
	}

	/**
	 * Performs polish operation on {@link Vehicle}
	 * 
	 * @param {@link Vehicle} to be polished with wax
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void polish(Vehicle vehicle) {
		LOGGER.info("polishing " + vehicle);
	}

	/**
	 * Performs paint operation on {@link Vehicle}
	 * 
	 * @param {@link Vehicle} to be painted
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public static void paint(Vehicle vehicle) {
		LOGGER.info("painting" + vehicle);
	}

	/**
	 * Processes the {@link Queue} of {@link ServiceTicket}s. The {@link VehicleService} for different {@link Vehicle}s from the
	 * {@link Queue} of {@link ServiceTicet} is performed by the {@link AutoCenter}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public void processServiceQueue() {
		ServiceTicket serviceTicket = serviceQueue.poll();
		while (serviceTicket != null) {
			List<VehicleService> requestedServices = serviceTicket.getServicesRequested();
			Vehicle vehicle = serviceTicket.getVehicle();
			for (VehicleService service : requestedServices) {
				if (service.equals(AutoMobileServiceConstants.WASH)) {
					wash(vehicle);
				} else if (service.equals(AutoMobileServiceConstants.POLISH)) {
					polish(vehicle);
				} else {
					paint(vehicle);
				}
			}
			serviceTicket = serviceQueue.poll();
		}
	}
}
