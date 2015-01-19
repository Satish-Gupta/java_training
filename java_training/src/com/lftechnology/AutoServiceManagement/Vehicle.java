package com.lftechnology.AutoServiceManagement;

/**
 * This class represents the basic functionality of a vehicle which used by various types of vehicles
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
abstract public class Vehicle {
	protected Long serialNo = 0L;

	/**
	 * Constructs {@link Vehicle}
	 */
	public Vehicle() {
	}

	/**
	 * Constructs
	 * 
	 * @param serialNo
	 */
	public Vehicle(Long serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * Returns the <code>serialNo</code> for this {@link Vehicle}
	 * 
	 * @return the serial Number for this {@link Vehicle}
	 */
	public Long getSerial() {
		return serialNo;
	}
}
