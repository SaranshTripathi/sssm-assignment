package com.assignee.assignment.stockmarket.service;

import java.util.List;

import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Trade;

public interface TradeServiceInterface {

	// -------------------------------------------------------------------------
	// Trade service methods
	// -------------------------------------------------------------------------
	
	/** */
	public List<Trade> filterTrades(Stock stock, long minutes);
	
	/** */
	void addTrade(Trade trade);
	
}
