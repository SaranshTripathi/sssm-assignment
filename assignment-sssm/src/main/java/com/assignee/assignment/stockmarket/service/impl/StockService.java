/**
 * 
 */
package com.assignee.assignment.stockmarket.service.impl;

import java.util.List;

import com.assignee.assignment.stockmarket.common.constant.StockMarketConstants;
import com.assignee.assignment.stockmarket.common.exception.InvalidValueException;
import com.assignee.assignment.stockmarket.dataaccess.StockDataHandlerInterface;
import com.assignee.assignment.stockmarket.dataaccess.handler.StockDataHandler;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade;
import com.assignee.assignment.stockmarket.service.StockServiceInterface;

/**
 * @author sharanshtripathi
 *
 */
public class StockService implements StockServiceInterface {

	// -------------------------------------------------------------------------
	// Local member variables - static/non static
	// -------------------------------------------------------------------------
	
	private static StockServiceInterface instance = null;
	private StockDataHandlerInterface stockHandler = new StockDataHandler();

	// -------------------------------------------------------------------------
	// Instantiation
	// -------------------------------------------------------------------------
	
	public static StockServiceInterface getInstance(boolean singleton) {
		instance = (instance == null || !singleton) ? new StockService() : instance;
		return instance;
	}

	// -------------------------------------------------------------------------
	// StockServiceInterface implementation
	// -------------------------------------------------------------------------
	
	@Override
	public void registerStock(Stock stock) {
		stockHandler.addStock(stock);
	}

	@Override
	public void deRegisterStock(Stock stock) {
		stockHandler.removeStock(stock);
	}
	
	@Override
	public Stock getStock(String symbol) {
		return stockHandler.getStock(symbol);
	}

	@Override
	public double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> trades) {
		double totalPriceQuantity = 0.0;
		int totalQuantity = 0;
		for (Trade trade : trades) {
			totalPriceQuantity = totalPriceQuantity + (trade.getPrice() * trade.getQuantity());
			totalQuantity = totalQuantity + trade.getQuantity();
		}
		return totalPriceQuantity / totalQuantity;
	}

	@Override
	public double calculateDividendYield(Stock stock, double price) {
		if (StockType.PREFERRED == stock.getStockType()) {
			return (stock.getFixedDividend() * stock.getParValue()) / price;
		}
		return stock.getLastDividend() / price;
	}
	
	@Override
	public double calculateGBCE() {
		double total = 1d;
		List<Trade> trades = stockHandler.getAllTrades();
		for (Trade trade : trades) {
			total = total * trade.getPrice();
		}
		return Math.pow(total, (1D / trades.size()));
	}
	
	@Override
	public double calculatePERatio(Stock stock, double price) throws InvalidValueException {
		double ld = stock.getLastDividend();
		if (ld == 0) {
			throw new InvalidValueException(StockMarketConstants.MessageUnableToCalculatePERatio);
		}
		return price / ld;
	}

	@Override
	public void clearAll() {
		stockHandler.clearAll();
	}

}
