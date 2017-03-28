package com.jpmorgan.assignment.stockmarket.service;

import java.util.List;

import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;

public interface TradeServiceInterface {

	/** */
	public List<Trade> filterTrades(Stock stock, long minutes);
	
	/** */
	void addTrade(Trade trade);
	
}
