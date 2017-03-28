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
public interface TradeDataHandlerInterface {

	  /** */
	  void addTrade(Trade trade);
	  
	  /** */
	  public List<Trade> filterTrades(Stock stock, long minutes);
}
