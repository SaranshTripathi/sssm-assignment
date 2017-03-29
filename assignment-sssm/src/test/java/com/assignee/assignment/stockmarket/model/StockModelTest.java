package com.assignee.assignment.stockmarket.model;

import org.junit.Assert;
import org.junit.Test;

import com.assignee.assignment.stockmarket.AbstractTest;
import com.assignee.assignment.stockmarket.model.Stock.StockType;

/**
 * @author sharanshtripathi
 */
public class StockModelTest extends AbstractTest {
	
	// -------------------------------------------------------------------------
	// Test
	// -------------------------------------------------------------------------
	
	@Test
	public void test() {
		Stock stock = new Stock("TEST", StockType.COMMON, 65, 45, 105);
		Assert.assertEquals("TEST", stock.getSymbol());
		Assert.assertEquals(65, stock.getLastDividend(), 0);
		Assert.assertEquals(45, stock.getFixedDividend(), 0);
		Assert.assertEquals(105, stock.getParValue(), 0);
		Assert.assertEquals(StockType.COMMON, stock.getStockType());
		
		// Update stock
		stock.setParValue(567);
		stock.setLastDividend(7);
		stock.setFixedDividend(8);
		stock.setStockType(StockType.PREFERRED);
		stock.setSymbol("TEST1");
		
		Assert.assertEquals("TEST1", stock.getSymbol());
		Assert.assertEquals(7, stock.getLastDividend(), 0);
		Assert.assertEquals(8, stock.getFixedDividend(), 0);
		Assert.assertEquals(567, stock.getParValue(), 0);
		Assert.assertEquals(StockType.PREFERRED, stock.getStockType());
		
	}

}
