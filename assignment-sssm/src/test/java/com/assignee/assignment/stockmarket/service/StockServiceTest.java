package com.assignee.assignment.stockmarket.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.assignee.assignment.stockmarket.AbstractTest;
import com.assignee.assignment.stockmarket.common.exception.InvalidValueException;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade;
import com.assignee.assignment.stockmarket.model.Trade.TradeIndicator;
import com.assignee.assignment.stockmarket.service.impl.StockService;

/**
 * @author sharanshtripathi
 */
public class StockServiceTest extends AbstractTest {

	private static final double EPSILON = 1E-3;
	private static StockServiceInterface stockService;

	@BeforeClass
	public static void setup() {
		stockService = StockService.getInstance(false);
		stockService.registerStock(new Stock("TEST1", StockType.COMMON, 0, 0, 100));
		stockService.registerStock(new Stock("TEST2", StockType.COMMON, 8, 0, 100));
		stockService.registerStock(new Stock("TEST3", StockType.COMMON, 23, 0, 60));
		stockService.registerStock(new Stock("TEST4", StockType.PREFERRED, 45, 0.04, 60));
	}

	@Test
	public void testPERatio() throws InvalidValueException {
		Stock stock = stockService.getStock("TEST3");
		assertEquals(1.021, stockService.calculatePERatio(stock, 23.5), EPSILON);
	}

	@Test
	public void testDividendYieldCommon() {
		Stock stock = stockService.getStock("TEST2");
		assertEquals(0.177, stockService.calculateDividendYield(stock, 45), EPSILON);
	}

	@Test
	public void testDividendYieldPreferred() {
		Stock stock = stockService.getStock("TEST4");
		assertEquals(0.0705, stockService.calculateDividendYield(stock, 34), EPSILON);
	}

	@Test
	public void testVolumeWeightedStockPrice() {
		Stock stock = stockService.getStock("TEST4");

		List<Trade> trades = new ArrayList<Trade>();
		trades.add(new Trade(stock, LocalDateTime.now(), 1, TradeIndicator.BUY, 53));
		trades.add(new Trade(stock, LocalDateTime.now(), 3, TradeIndicator.BUY, 56.5));
		trades.add(new Trade(stock, LocalDateTime.now(), 1, TradeIndicator.BUY, 78.9));
		assertEquals(60.279, stockService.calculateVolumeWeightedStockPrice(stock, trades), EPSILON);
	}

	@Test
	public void testGBCE() {
		Stock stock1 = stockService.getStock("TEST1");
		Stock stock2 = stockService.getStock("TEST2");
		Stock stock3 = stockService.getStock("TEST3");
		
		List<Trade> trades = new ArrayList<Trade>();
		trades.add(new Trade(stock1, LocalDateTime.now(), 34, TradeIndicator.BUY, 25.45));
		stock1.setTrades(trades);
		
	    trades = new ArrayList<Trade>();
		trades.add(new Trade(stock2, LocalDateTime.now(), 35, TradeIndicator.BUY, 15.8));
		stock2.setTrades(trades);
		
	    trades = new ArrayList<Trade>();
		trades.add(new Trade(stock3, LocalDateTime.now(), 36, TradeIndicator.BUY, 3.78));
		stock3.setTrades(trades);
		
		assertEquals(11.4977, stockService.calculateGBCE(), EPSILON);
	}

}
