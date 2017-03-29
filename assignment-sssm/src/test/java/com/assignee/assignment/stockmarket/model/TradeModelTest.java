package com.assignee.assignment.stockmarket.model;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.assignee.assignment.stockmarket.AbstractTest;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade.TradeIndicator;

/**
 * @author sharanshtripathi
 */
public class TradeModelTest extends AbstractTest {

	// -------------------------------------------------------------------------
	// Test
	// -------------------------------------------------------------------------
	
	@Test
	public void test() {
		Stock stock = new Stock("TEST", StockType.COMMON, 65, 45, 105);
		Trade trade = new Trade(stock, LocalDateTime.now(), 23, TradeIndicator.SELL, 1.5);
		Assert.assertEquals(stock, trade.getStock());
		Assert.assertEquals(23, trade.getQuantity(), 0);
		Assert.assertEquals(1.5, trade.getPrice(), 0);
		Assert.assertEquals(TradeIndicator.SELL, trade.getTradeIndicator());
		
		// Update stock
		trade.setQuantity(45);
		trade.setPrice(734);
		trade.setTradeIndicator(TradeIndicator.BUY);

		Assert.assertEquals(45, trade.getQuantity(), 0);
		Assert.assertEquals(734, trade.getPrice(), 0);
		Assert.assertEquals(TradeIndicator.BUY, trade.getTradeIndicator());
		
	}

}
