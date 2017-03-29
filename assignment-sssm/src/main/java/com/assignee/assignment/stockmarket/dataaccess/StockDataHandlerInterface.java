/**
 * 
 */
package com.assignee.assignment.stockmarket.dataaccess;

import java.util.List;

import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Trade;

/**
 * @author sharanshtripathi
 *
 */
public interface StockDataHandlerInterface {

	// -------------------------------------------------------------------------
	// Local stock data helpers
	// -------------------------------------------------------------------------
	
	/** */
	void addStock(Stock stock);

	/** */
	void removeStock(Stock stock);
	
	/** */
	Stock getStock(String symbol);

	/** */
	public List<Trade> getAllTrades();

	/** */
	void clearAll();
}
