package com.jpmorgan.assignment.stockmarket.service;

import java.util.List;

import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;

public interface StockServiceInterface {

	/** */
	public void addStock(Stock stock);

	/** */
	public Stock getStock(String symbol);

	/** */
	public double calculateDividendYield(Stock stock, double price);

	/** */
	public double calculatePERatio(Stock stock, double price);

	/** */
	public double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> trades);
	
	/** */
	public double calculateGBCE();
	
}
