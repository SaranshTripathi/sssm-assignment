/**
 * 
 */
package com.assignee.assignment.stockmarket.model;

import java.time.LocalDateTime;

/**
 * @author sharanshtripathi
 *
 */
public class Trade {

	/** */
	private LocalDateTime timeStamp = null;
	/** */
	private Stock stock = null;
	/** */
	private TradeIndicator tradeIndicator = null; // No default value.
	/** */
	private int quantity = 0;
	/** */
	private double price = 0.0;
	
	/** {@link TradeIndicator} enum to represent trade indicators for specific stock. */
	public enum TradeIndicator {
		BUY, SELL
	}

	public Trade(Stock stock, LocalDateTime timestamp, int quantity, TradeIndicator type, double price) {
		super();
		this.stock = stock;
		this.quantity = quantity;
		this.tradeIndicator = type;
		this.price = price;
		this.timeStamp = timestamp;
	}
	
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	/**
	 * @return the tradeIndicator
	 */
	public TradeIndicator getTradeIndicator() {
		return tradeIndicator;
	}
	/**
	 * @param tradeIndicator the tradeIndicator to set
	 */
	public void setTradeIndicator(TradeIndicator tradeIndicator) {
		this.tradeIndicator = tradeIndicator;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
