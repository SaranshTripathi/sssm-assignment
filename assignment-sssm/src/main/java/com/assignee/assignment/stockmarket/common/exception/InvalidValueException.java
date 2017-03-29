package com.assignee.assignment.stockmarket.common.exception;

/**
 * {@link InvalidValueException} exception to indicate if value is invalid.
 * 
 * @author sharanshtripathi
 *
 */
@SuppressWarnings("serial")
public class InvalidValueException extends StockMarketControllerException {

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	
	/** Constructor. */
	public InvalidValueException(String message){
		super(message);
	}
}
