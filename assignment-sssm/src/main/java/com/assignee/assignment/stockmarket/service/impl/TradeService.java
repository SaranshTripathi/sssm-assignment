/**
 * 
 */
package com.assignee.assignment.stockmarket.service.impl;

import java.util.List;

import com.assignee.assignment.stockmarket.dataaccess.TradeDataHandlerInterface;
import com.assignee.assignment.stockmarket.dataaccess.handler.TradeDataHandler;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Trade;
import com.assignee.assignment.stockmarket.service.TradeServiceInterface;

/**
 * @author sharanshtripathi
 *
 */
public class TradeService implements TradeServiceInterface {

	// -------------------------------------------------------------------------
	// Local member variables - static/non static
	// -------------------------------------------------------------------------
	
	private static TradeServiceInterface instance = null;
	private TradeDataHandlerInterface tradeHandler = new TradeDataHandler();

	// -------------------------------------------------------------------------
	// Instantiation
	// -------------------------------------------------------------------------
	
	public static TradeServiceInterface getInstance(boolean singleton) {
		instance = (instance == null || !singleton) ? new TradeService() : instance;
		return instance;
	}

	// -------------------------------------------------------------------------
	// TradeServiceInterface implementation
	// -------------------------------------------------------------------------
	
	@Override
	public List<Trade> filterTrades(Stock stock, long minutes) {
		return tradeHandler.filterTrades(stock, minutes);
	}

	@Override
	public void addTrade(Trade trade) {
		tradeHandler.addTrade(trade);
	}

}
