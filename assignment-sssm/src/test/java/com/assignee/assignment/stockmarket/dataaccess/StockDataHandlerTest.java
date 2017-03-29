package com.assignee.assignment.stockmarket.dataaccess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.assignee.assignment.stockmarket.AbstractTest;
import com.assignee.assignment.stockmarket.dataaccess.handler.StockDataHandler;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;

/**
 * @author sharanshtripathi
 */
public class StockDataHandlerTest extends AbstractTest {

	private StockDataHandlerInterface handler;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.handler = new StockDataHandler();
	}
	
	@Test
	public void testAddStock() {
		Stock stock = new Stock("ADD", StockType.COMMON, 0.0, 0.0, 100);
		this.handler.addStock(stock);
		Assert.assertEquals(stock, this.handler.getStock("ADD")); // Test of get stock
	}
	
	@Test
	public void testRemoveStock() {
		Stock stock = new Stock("REMOVE", StockType.COMMON, 0.0, 0.0, 100);
		this.handler.addStock(stock);
		Assert.assertFalse("Unable to create new stock.", this.handler.getStock("REMOVE") == null);
		this.handler.removeStock(stock);
		Assert.assertTrue("Success", this.handler.getStock("REMOVE") == null);
	}
	
	@Test
	public void testClearAll() {
		Stock stock = new Stock("CLEAR1", StockType.COMMON, 0.0, 0.0, 100);
		Stock stock1 = new Stock("CLEAR2", StockType.PREFERRED, 0.0, 0.02, 100);
		this.handler.addStock(stock);
		this.handler.addStock(stock1);
		Assert.assertFalse("Unable to create new stock.", this.handler.getStock("CLEAR1") == null);
		this.handler.clearAll();
		Assert.assertTrue("Success", this.handler.getStock("CLEAR1") == null && this.handler.getStock("CLEAR2") == null );
	}
}
