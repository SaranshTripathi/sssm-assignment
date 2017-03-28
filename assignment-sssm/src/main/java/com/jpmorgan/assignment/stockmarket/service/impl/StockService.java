/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.service.impl;

import java.util.List;

import com.jpmorgan.assignment.stockmarket.dataaccess.StockDataHandlerInterface;
import com.jpmorgan.assignment.stockmarket.dataaccess.handler.StockDataHandler;
import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Stock.StockType;
import com.jpmorgan.assignment.stockmarket.model.Trade;
import com.jpmorgan.assignment.stockmarket.service.StockServiceInterface;

/**
 * @author sharanshtripathi
 *
 */
public class StockService implements StockServiceInterface {

	public static StockServiceInterface instance = null;
	private StockDataHandlerInterface stockHandler = new StockDataHandler();

	public static StockServiceInterface getInstance(boolean singleton) {
		instance = (instance == null || !singleton) ? new StockService() : instance;
		return instance;
	}

	@Override
	public void addStock(Stock stock) {
		stockHandler.addStock(stock);
	}

	@Override
	public Stock getStock(String symbol) {
		return stockHandler.getStock(symbol);
	}

	@Override
	public double calculatePERatio(Stock stock, double price) {
		return price / stock.getLastDividend();
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
		double total = 1;
		List<Trade> trades = stockHandler.getAllTrades();
		for (Trade trade : trades) {
			total = total * trade.getPrice();
		}
		return Math.pow(total, (1D / trades.size()));
	}

}
