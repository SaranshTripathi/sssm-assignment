/**
 * 
 */
package com.assignee.assignment.stockmarket.common.constant;

import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;

/**
 * @author sharanshtripathi
 *
 */
public final class StockMarketConstants {

	/**
	 * Default constructor.
	 * 
	 * The class StockMarketConstants is not to be constructed as object as it
	 * provides only static variables and methods, thus preventing any class
	 * instantiation here.
	 * 
	 * @throws ClassCastException
	 *             Exception thrown when attempting to instantiate this class.
	 */
	public StockMarketConstants() throws ClassCastException {
		// Deny instantiation
		throw new ClassCastException();
	}

	/** Constant defining the stock attributes for default stocks. */
	public static final Stock DefaultStocks[] = 
		{
			new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0),
			new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0), 
			new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0),
			new Stock("GIN", StockType.PREFERRED, 8.0, 0.02, 100.0), 
			new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0) 
		};
	
	/** Constant defining main menu items for stock market controller. */
	public static final String MainMenu[] = {
			" ----- Menu-----",
			"1: Add new stock",
			"2: Remove existing stock",
			"3: Calculate dividend yield for stock",
			"4: Calculate P/E ratio for stock",
			"5: Record a trade for stock",
			"6: Calculate volume weighted stock price for stock",
			"7: Calculate GBCE all share index",
			"8: Clear all stocks",
			"9: Exit"
	};
	
	public static final String LineSeperator = "---------------------------------------------"; 
	
	public static final String SimpleStockMarket = "--------------------- Simple stock market-----------------------";
	public static final String SampleDataAdded   = "Added: Sample data from the Global Beverage Corporation Exchange";
	
	public static final String MessageInputStockSymbol = "Please input stock symbol";
	public static final String MessageInputStockNotFound = "Stock not found";
	public static final String InvalidInputStockSymbol = "Invalid stock symbol";

	public static final String MessageInputStockType = "Please input stock type (COMMON/PREFERRED)";
	public static final String InvalidStockType = "Invalid stock type: Must be COMMON or PREFERRED";
	
	public static final String MessageInputStockPrice = "Please input stock price";
	public static final String InvalidStockPriceNegative = "Invalid price: Must be greated than 0";
	public static final String InvalidStockPriceNaN = "Invalid price: Not a number";
	
	public static final String MessageInputStockFixedDividend = "Please input stock fixed dividend %";
	public static final String InvalidStockFixedDividendNegative = "Invalid fixed Dividend: Must be a non negative number";
	public static final String InvalidStockFixedDividendNaN = "Invalid fixed dividend: Not a number";
	
	public static final String MessageInputStockLastDividend = "Please input stock last dividend";
	public static final String InvalidStockLastDividendNegative = "Invalid last Dividend: Must be a non negative number";
	public static final String InvalidStockLastDividendNaN = "Invalid last dividend: Not a number";
	
	public static final String MessageInputStockParValue = "Please input stock par value";
	public static final String InvalidStockParValueNegative = "Invalid par value: Must be greated than 0";
	public static final String InvalidStockParValueNaN = "Invalid par value: Not a number";
	
	public static final String MessageInputTradeIndicator = "Please input trade indicator (BUY/SELL)";
	public static final String InvalidTradeType = "Invalid trade type: Must be BUY or SELL";
	
	public static final String MessageInputQuantity = "Please input quantity";
	public static final String InvalidTradeQuantityNegative = "Invalid quantity: Must be greated than 0";
	public static final String InvalidTradeQuantityNaN = "Invalid quantity: Not a number";
	public static final String InvalidValueOrOption = "Invalid Value or Option provided.";
	public static final String MessageUnableToCalculatePERatio = "Unable to calculate P/E ratio as last dividend is 0";
	
	public static final String StatusStockAdded = "Stock added: ";
	public static final String StatusStockRemoved = "Stock removed: ";
	public static final String StatusDividendYield = "Dividend Yield: ";
	public static final String StatusPERatio = "PE Ratio: ";
	public static final String StatusVolumeWeightedStockPriceNoTrades = "Volume Weighted Stock Price: No trades";
	public static final String StatusVolumeWeightedStockPrice = "Volume Weighted Stock Price: ";
	public static final String StatusTradeRecordedSuccess = "Trade recorded successfully";
	public static final String StatusGBCE = "GBCE: ";
	public static final String StatusAllStockRemoved = "All stocks removed successfully";

	}

