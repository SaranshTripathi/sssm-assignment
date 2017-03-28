/**
 * 
 */
package com.jpmorgan.assignment.stockmarket.dataaccess.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmorgan.assignment.stockmarket.dataaccess.StockDataHandlerInterface;
import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;

/**
 * @author sharanshtripathi
 *
 */
public class StockDataHandler implements StockDataHandlerInterface {

	private Map<String, Stock> stocks = new HashMap<String, Stock>();

	public void addStock(Stock stock) {
		stocks.put(stock.getSymbol(), stock);	
	}

	public Stock getStock(String symbol) {
	    return stocks.get(symbol);
	}

	@Override
	public List<Trade> getAllTrades() {
		List<Trade> trades = new ArrayList<>();
		stocks.forEach((k,v) -> {
			trades.addAll(v.getTrades());
		});
		return trades;
	}

}
