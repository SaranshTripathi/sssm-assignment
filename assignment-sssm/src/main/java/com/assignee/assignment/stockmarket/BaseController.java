/**
 * 
 */
package com.assignee.assignment.stockmarket;

import java.util.Scanner;

import com.assignee.assignment.stockmarket.common.constant.StockMarketConstants;
import com.assignee.assignment.stockmarket.common.exception.InvalidValueException;
import com.assignee.assignment.stockmarket.common.exception.StockMarketControllerException;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade.TradeIndicator;
import com.assignee.assignment.stockmarket.service.StockServiceInterface;
import com.assignee.assignment.stockmarket.service.TradeServiceInterface;
import com.assignee.assignment.stockmarket.service.impl.StockService;
import com.assignee.assignment.stockmarket.service.impl.TradeService;

/**
 * @author sharanshtripathi
 *
 */
public class BaseController {

	// -------------------------------------------------------------------------
	// Static members 
	// -------------------------------------------------------------------------
	
	protected static StockServiceInterface stockService = StockService.getInstance(true);
	protected static TradeServiceInterface tradeService = TradeService.getInstance(true);
	
	// -------------------------------------------------------------------------
	// Common helpers
	// -------------------------------------------------------------------------
	
	protected static void initialSetup() {
		logMessage(StockMarketConstants.SimpleStockMarket);
		addDummyStockData();
		logMessage(StockMarketConstants.SampleDataAdded);
		showMenu();
	}
	
	protected static void showMenu() {
		for (String item : StockMarketConstants.MainMenu) {
			System.out.println(item);
		}
	}

	protected static void addDummyStockData() {
		for (Stock stock : StockMarketConstants.DefaultStocks) {
			stockService.registerStock(stock);
		}
	}
	
	protected static void logMessage(String result) {
		System.out.println(StockMarketConstants.LineSeperator);
		System.out.println(result);
		System.out.println(StockMarketConstants.LineSeperator);
	}
	
	// -------------------------------------------------------------------------
	// Stock helpers
	// -------------------------------------------------------------------------
	
	protected static Stock selectedStock(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockSymbol);
		String stockSymbol = scanner.nextLine();
		Stock stock = stockService.getStock(stockSymbol.toUpperCase());
		if (stock == null) {
			throw new StockMarketControllerException(StockMarketConstants.MessageInputStockNotFound);
		}
		return stock;
	}

	protected static String selectedStockSymbol(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockSymbol);
		String stockSymbol = scanner.nextLine();
		if (stockSymbol == null || stockSymbol.isEmpty()) {
			throw new StockMarketControllerException(StockMarketConstants.InvalidInputStockSymbol);
		}
		return stockSymbol.toUpperCase();
	}
	
	protected static StockType selectedStockType(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockType);
		String type = scanner.nextLine();
		try {
			return StockType.valueOf(type.toUpperCase());
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidStockType);
		}
	}
	
	protected static double selectedLastDividend(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockLastDividend);
		String stockPrice = scanner.nextLine();
		try {
			double result = Double.parseDouble(stockPrice);
			if (result < 0) {
				throw new StockMarketControllerException(StockMarketConstants.InvalidStockLastDividendNegative);
			}
			return result;
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidStockLastDividendNaN);
		}
	}
	
	protected static double selectedFixedDividend(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockFixedDividend);
		String stockPrice = scanner.nextLine();
		try {
			double result = Double.parseDouble(stockPrice);
			if (result < 0) {
				throw new StockMarketControllerException(StockMarketConstants.InvalidStockFixedDividendNegative);
			}
			return result / 100.0;
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidStockFixedDividendNaN);
		}
	}
	
	protected static double selectedParValue(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockParValue);
		String stockPrice = scanner.nextLine();
		try {
			double result = Double.parseDouble(stockPrice);
			if (result <= 0) {
				throw new StockMarketControllerException(StockMarketConstants.InvalidStockParValueNegative);
			}
			return result;
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidStockParValueNaN);
		}
	}
	
	// -------------------------------------------------------------------------
	// Trade helpers
	// -------------------------------------------------------------------------
	
	protected static double selectedPrice(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputStockPrice);
		String stockPrice = scanner.nextLine();
		try {
			double result = Double.parseDouble(stockPrice);
			if (result <= 0) {
				throw new StockMarketControllerException(StockMarketConstants.InvalidStockPriceNegative);
			}
			return result;
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidStockPriceNaN);
		}
	}

	protected static TradeIndicator getTradeIndicator(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputTradeIndicator);
		String type = scanner.nextLine();
		try {
			return TradeIndicator.valueOf(type.toUpperCase());
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidTradeType);
		}
	}

	protected static int selectedQuantity(Scanner scanner) throws StockMarketControllerException {
		System.out.println(StockMarketConstants.MessageInputQuantity);
		String quantity = scanner.nextLine();
		try {
			int result = Integer.parseInt(quantity);
			if (result <= 0) {
				throw new StockMarketControllerException(StockMarketConstants.InvalidTradeQuantityNegative);
			}
			return result;
		} catch (Exception e) {
			throw new InvalidValueException(StockMarketConstants.InvalidTradeQuantityNaN);
		}
	}
}
