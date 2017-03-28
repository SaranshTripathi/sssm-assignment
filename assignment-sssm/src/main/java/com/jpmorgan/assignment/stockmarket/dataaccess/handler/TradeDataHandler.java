package com.jpmorgan.assignment.stockmarket.dataaccess.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.jpmorgan.assignment.stockmarket.dataaccess.TradeDataHandlerInterface;
import com.jpmorgan.assignment.stockmarket.model.Stock;
import com.jpmorgan.assignment.stockmarket.model.Trade;

/**
 * @author sharanshtripathi
 *
 */
public class TradeDataHandler implements TradeDataHandlerInterface {
	
	@Override
	public void addTrade(Trade trade) {
	    Stock stock = trade.getStock();
		List<Trade> trades = stock.getTrades();
	    if (trades == null) {
	        trades = new ArrayList<Trade>();
	        stock.setTrades(trades);
	    }
	    trades.add(trade);		
	}
	
	@Override
	public List<Trade> filterTrades(Stock stock, long minutes) {
		List<Trade> retval = new ArrayList<>();
		List<Trade> trades = stock.getTrades();
		Collections.sort(trades, (t1, t2) -> t1.getTimeStamp().compareTo(t2.getTimeStamp())); // Do sorting
	    Iterator<Trade> iterator = trades.iterator();
	    LocalDateTime pastTime = getLocalDateTimeBefore(minutes);
		while (iterator.hasNext()) {
	      Trade trade = iterator.next();
	      if (trade.getTimeStamp().isBefore(pastTime)) break;
	      retval.add(trade);
	    }
	    return retval;
	}
	
	private LocalDateTime getLocalDateTimeBefore(long minutes){
		return LocalDateTime.now().minusMinutes(minutes);
	}
	
}
