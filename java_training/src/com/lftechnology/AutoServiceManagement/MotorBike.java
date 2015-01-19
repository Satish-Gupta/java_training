package com.lftechnology.AutoServiceManagement;

public class MotorBike extends Vehicle {
	/**
	 * constructs {@link MotorBike}
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public MotorBike() {
	}

	/**
	 * constructs {@link MotorBike} with supplied serial number
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public MotorBike(Long serial) {
		this.serialNo = serial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "bike with id " + serialNo.toString();
	}
}
