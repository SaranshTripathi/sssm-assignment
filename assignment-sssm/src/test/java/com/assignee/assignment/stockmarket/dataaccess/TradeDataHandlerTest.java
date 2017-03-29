/**
 * 
 */
package com.assignee.assignment.stockmarket.dataaccess;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.assignee.assignment.stockmarket.AbstractTest;
import com.assignee.assignment.stockmarket.dataaccess.handler.StockDataHandler;
import com.assignee.assignment.stockmarket.dataaccess.handler.TradeDataHandler;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade;
import com.assignee.assignment.stockmarket.model.Trade.TradeIndicator;

/**
 * @author sharanshtripathi
 *
 */
public class TradeDataHandlerTest extends AbstractTest {

	// -------------------------------------------------------------------------
	// Local members
	// -------------------------------------------------------------------------
	
	private StockDataHandlerInterface stockHandler;
	private TradeDataHandlerInterface tradeHandler;
	
	// -------------------------------------------------------------------------
	// Initial setup
	// -------------------------------------------------------------------------
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.stockHandler = new StockDataHandler();
		this.tradeHandler = new TradeDataHandler();
	}
	
	// -------------------------------------------------------------------------
	// Tests
	// -------------------------------------------------------------------------
	
	@Test
	public void testAddTrade() {
		Stock stock = new Stock("STOCK1", StockType.COMMON, 0.0, 0.0, 100);
		this.stockHandler.addStock(stock);
		for (int i = 1; i < 6; i++) {
			this.tradeHandler.addTrade(new Trade(stock, LocalDateTime.now(), i*2, TradeIndicator.BUY, i*30));
		}
		List<Trade> list = this.stockHandler.getAllTrades();
		Assert.assertFalse("Unable to create trades.", list == null || list.isEmpty());
		Assert.assertEquals(5, list.size());
	}
	
	@Test
	public void testFilterTrades() {
		Stock stock = new Stock("STOCK1", StockType.COMMON, 0.0, 0.0, 100);
		this.stockHandler.addStock(stock);
		for (int i = 1; i < 4; i++) {
			this.tradeHandler.addTrade(new Trade(stock, LocalDateTime.now().minusMinutes(5), i*2, TradeIndicator.BUY, i*30)); // Before 5 minutes
		}
		
		for (int i = 1; i < 7; i++) {
			this.tradeHandler.addTrade(new Trade(stock, LocalDateTime.now(), i*3, TradeIndicator.SELL, i*35)); // just now
		}
		
		List<Trade> list = this.stockHandler.getAllTrades();
		Assert.assertFalse("Unable to create trades.", list == null || list.isEmpty());
		Assert.assertFalse("Unable to create trades.", list.size() != 9);
		
		List<Trade> filtered = this.tradeHandler.filterTrades(stock, 2);
		Assert.assertFalse("Unable to filter trades.", filtered == null || filtered.isEmpty());
		Assert.assertEquals(6, filtered.size());
	}

}
