/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.service.impl;

import java.util.List;

import com.jpmorgan.assignment.stockmarket.dataaccess.TradeDataHandlerInterface;
import com.jpmorgan.assignment.stockmarket.dataaccess.handler.TradeDataHandler;
import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;
import com.jpmorgan.assignment.stockmarket.service.TradeServiceInterface;

/**
 * @author sharanshtripathi
 *
 */
public class TradeService implements TradeServiceInterface {

	public static TradeServiceInterface instance = null;
	private TradeDataHandlerInterface tradeHandler = new TradeDataHandler();

	public static TradeServiceInterface getInstance(boolean singleton) {
		instance = (instance == null || !singleton) ? new TradeService() : instance;
		return instance;
	}

	@Override
	public List<Trade> filterTrades(Stock stock, long minutes) {
		return tradeHandler.filterTrades(stock, minutes);
	}

	@Override
	public void addTrade(Trade trade) {
		tradeHandler.addTrade(trade);
	}

}
