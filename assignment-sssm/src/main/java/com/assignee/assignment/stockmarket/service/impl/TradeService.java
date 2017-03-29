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
