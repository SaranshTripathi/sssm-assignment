/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.model;

import java.util.List;

/**
 * @author sharanshtripathi
 *
 */
public class Stock {

	/** */
	private StockType stockType = StockType.COMMON;
	/** */
	private List<Trade> trades = null;
	/** */
	private String symbol;
	/** */
	private double lastDividend;
	/** */
	private double fixedDividend;
	/** */
	private double parValue;
	
	/** {@link StockType} enum to represent the stock type for stocks. */
	public enum StockType {
		COMMON, PREFERRED
	}
	
	/** Default constructor */
	public Stock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
		super();
		this.symbol = symbol;
		this.stockType = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the stockType
	 */
	public StockType getStockType() {
		return stockType;
	}
	/**
	 * @param stockType the stockType to set
	 */
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}
	/**
	 * @return the fixedDividend
	 */
	public double getFixedDividend() {
		return fixedDividend;
	}
	/**
	 * @param fixedDividend the fixedDividend to set
	 */
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	/**
	 * @return the trades
	 */
	public List<Trade> getTrades() {
		return trades;
	}
	/**
	 * @param trades the trades to set
	 */
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	/**
	 * @return the parValue
	 */
	public double getParValue() {
		return parValue;
	}
	/**
	 * @param parValue the parValue to set
	 */
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	/**
	 * @return the lastDividend
	 */
	public double getLastDividend() {
		return lastDividend;
	}
	/**
	 * @param lastDividend the lastDividend to set
	 */
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
}
