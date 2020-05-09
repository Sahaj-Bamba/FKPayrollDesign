package com.Sahaj.Utilities;

/**
 * Different Global Control variables
 *
 */

public class Controller {

	/**
	 * The main instance of the class
	 */
	private static Controller controller = null;

	private Controller() {
	}

	/**
	 * Creates the instance and return
	 *
	 * @return the instance of the object
	 */
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}


}
