/**
 * 
 */
package com.assignee.assignment.stockmarket.common.exception;

/**
 * An ControllerException is thrown by stock market controller if it has an unexpected problem.
 *
 * @author Sharansh Tripathi
 */
@SuppressWarnings("serial")
public class StockMarketControllerException extends Exception {

	/**
	 * Create an ControllerException with a specific message and cause.
	 * @param message the message
	 * @param cause the cause
	 */
	public StockMarketControllerException(String message, Exception cause) {
		super(message, cause);
	}

	/**
	 * Create an ControllerException with a specific message.
	 * @param message the message
	 */
	public StockMarketControllerException(String message) {
		super(message);
	}

}
