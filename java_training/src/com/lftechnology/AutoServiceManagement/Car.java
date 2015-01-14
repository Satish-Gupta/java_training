package com.lftechnology.AutoServiceManagement;

import java.util.logging.Logger;

/**
 * This class represents car object and allows various service operation for it.
 * 
 * @author satish<satishgupta@lftechnology.com>
 * 
 */
public class Car {
	private static Logger LOGGER = Logger.getLogger(Car.class.getName());
	private Long serialNo = 0L;

	/**
	 * constructs <code>Car</code>
	 * 
	 * @author satish
	 */
	public Car() {
	}

	/**
	 * constructs <code>Car</code> with supplied serial number
	 * 
	 * @author satish
	 */
	public Car(Long serial) {
		this.serialNo = serial;
	}

	/**
	 * Performs wash operation on this <code>Car</code>
	 * 
	 * @author satish
	 */
	public void wash() {
		LOGGER.info("washing car");
	}

	/**
	 * Performs wax operation on this <code>Car</code>
	 * 
	 * @author satish
	 */
	public void wax() {
		LOGGER.info("waxing car");
	}

	/**
	 * Performs color operation on this <code>Car</code>
	 * 
	 * @author satish
	 */
	public void color() {
		LOGGER.info("coloring car");
	}

}
