/**
 * 
 */
package com.assignee.assignment.stockmarket.dataaccess.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.assignee.assignment.stockmarket.dataaccess.StockDataHandlerInterface;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Trade;

/**
 * @author sharanshtripathi
 *
 */
public class StockDataHandler implements StockDataHandlerInterface {

	// -------------------------------------------------------------------------
	// Member variables
	// -------------------------------------------------------------------------
	
	private Map<String, Stock> stocks = new ConcurrentHashMap<String, Stock>();

	// -------------------------------------------------------------------------
	// StockDataHandlerInterface implementation
	// -------------------------------------------------------------------------
	
	@Override
	public void addStock(Stock stock) {
		stocks.put(stock.getSymbol(), stock);	
	}

	@Override
	public void removeStock(Stock stock) {
		stocks.remove(stock.getSymbol());	
	}
	
	@Override
	public Stock getStock(String symbol) {
	    return stocks.get(symbol);
	}

	@Override
	public List<Trade> getAllTrades() {
		List<Trade> retval = new ArrayList<>();
		stocks.forEach((k,v) -> {
			List<Trade> trades  = v.getTrades();
			if (trades != null && trades.isEmpty() == false) retval.addAll(v.getTrades());
		});
		return retval;
	}

	@Override
	public void clearAll() {
		stocks.clear();
	}
	
}
