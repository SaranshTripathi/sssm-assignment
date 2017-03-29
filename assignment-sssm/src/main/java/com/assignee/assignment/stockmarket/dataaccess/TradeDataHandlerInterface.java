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
public interface TradeDataHandlerInterface {

	  /** Method to add a trade for particular {@link Stock}*/
	  void addTrade(Trade trade);
	  
	  /** Method to filter the trades for a time frame for particular {@link Stock}*/
	  public List<Trade> filterTrades(Stock stock, long pastTime);
}
