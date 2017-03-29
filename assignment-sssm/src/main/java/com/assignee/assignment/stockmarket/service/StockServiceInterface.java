package com.assignee.assignment.stockmarket.service;

import java.util.List;

import com.assignee.assignment.stockmarket.common.exception.InvalidValueException;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Trade;

public interface StockServiceInterface {

	/** */
	public void registerStock(Stock stock);

	/** */
	public void deRegisterStock(Stock stock);
	
	/** */
	public Stock getStock(String symbol);

	/** */
	public double calculateDividendYield(Stock stock, double price);

	/** */
	public double calculatePERatio(Stock stock, double price) throws InvalidValueException;

	/** */
	public double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> trades);
	
	/** */
	public double calculateGBCE();

	/** */
	public void clearAll();
	
}
