/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.dataaccess;

import java.util.List;

import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;

/**
 * @author sharanshtripathi
 *
 */
public interface StockDataHandlerInterface {

	/** */
	void addStock(Stock stock);

	/** */
	Stock getStock(String symbol);

	/** */
	public List<Trade> getAllTrades();
}
