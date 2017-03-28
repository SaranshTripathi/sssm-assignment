/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.common.exception;

/**
 * An ControllerException is thrown by stock market controller if it has an unexpected problem.
 *
 * @author Sharansh Tripathi
 */
@SuppressWarnings("serial")
public class ControllerException extends Exception {

	/**
	 * Create an ControllerException with a specific message and cause.
	 * @param message the message
	 * @param cause the cause
	 */
	public ControllerException(String message, Exception cause) {
		super(message, cause);
	}

	/**
	 * Create an ControllerException with a specific message.
	 * @param message the message
	 */
	public ControllerException(String message) {
		super(message);
	}

}
