package com.lftechnology.AutoServiceManagement;

/**
 * This class represents car object and allows various service operation for it.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class Car {
	private Long serialNo = 0L;

	/**
	 * constructs <code>Car</code>
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Car() {
	}

	/**
	 * constructs <code>Car</code> with supplied serial number
	 * 
	 * @author satish<satishgupta@lftechnology.com>
	 */
	public Car(Long serial) {
		this.serialNo = serial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "car with id " + serialNo.toString();
	}
}
