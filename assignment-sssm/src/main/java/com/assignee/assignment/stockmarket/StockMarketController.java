package com.assignee.assignment.stockmarket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.assignee.assignment.stockmarket.common.constant.StockMarketConstants;
import com.assignee.assignment.stockmarket.common.exception.InvalidValueException;
import com.assignee.assignment.stockmarket.common.exception.StockMarketControllerException;
import com.assignee.assignment.stockmarket.model.Stock;
import com.assignee.assignment.stockmarket.model.Stock.StockType;
import com.assignee.assignment.stockmarket.model.Trade;
import com.assignee.assignment.stockmarket.model.Trade.TradeIndicator;

/**
 * @author sharanshtripathi
 *
 */
public class StockMarketController extends BaseController {

	// -------------------------------------------------------------------------
	// Local helpers - Menu
	// -------------------------------------------------------------------------
	
	private static void registerNewStock(String symbol, StockType stockType, double lastDividend, double fixedDividend,
			double parValue) {
		stockService.registerStock(new Stock(symbol, stockType, lastDividend, fixedDividend, parValue));
		logMessage(StockMarketConstants.StatusStockAdded + symbol);
	}
	
	private static void removeStock(Stock stock) {
		stockService.deRegisterStock(stock);
		logMessage(StockMarketConstants.StatusStockRemoved + stock.getSymbol());
	}
	
	private static void calculateDividendYield(Stock stock, double price) throws StockMarketControllerException {
		double result = stockService.calculateDividendYield(stock, price);
		logMessage(StockMarketConstants.StatusDividendYield + result);
	}

	private static void calculatePERatio(Stock stock, double price) throws StockMarketControllerException {
		double result = stockService.calculatePERatio(stock, price);
		logMessage(StockMarketConstants.StatusPERatio + result);
	}

	private static void calculateVolumeWeightedStockPrice(Stock stock) throws StockMarketControllerException {
		List<Trade> trades = tradeService.filterTrades(stock, 15);
		if (trades == null || trades.isEmpty()) {
			logMessage(StockMarketConstants.StatusVolumeWeightedStockPriceNoTrades);
		} else {
			double result = stockService.calculateVolumeWeightedStockPrice(stock, trades);
			logMessage(StockMarketConstants.StatusVolumeWeightedStockPrice + result);
		}
	}

	private static void recordTrade(Stock stock, int quantity, TradeIndicator type, double price)
			throws StockMarketControllerException {
		tradeService.addTrade(new Trade(stock, LocalDateTime.now(), quantity, type, price));
		logMessage(StockMarketConstants.StatusTradeRecordedSuccess);
	}

	private static void calculateGBCE() throws StockMarketControllerException {
		logMessage(StockMarketConstants.StatusGBCE + stockService.calculateGBCE());
	}
	
	private static void clearAll() {
		stockService.clearAll();
		logMessage(StockMarketConstants.StatusAllStockRemoved);
	}
	
	// -------------------------------------------------------------------------
	// Main controller
	// -------------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
		// Precondition check

		// Do initial set up
		initialSetup();
		
		// Manage options 
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String selction = null;
		do {
			selction = scanner.nextLine();
			try {
				int option = Integer.parseInt(selction);
				Stock stock;
				double price;
				switch (option) {
				case 1:
					String symbol = selectedStockSymbol(scanner);
					StockType stockType = selectedStockType(scanner);
					double fixedDividend = 0;
					if (stockType == StockType.PREFERRED) {
						fixedDividend = selectedFixedDividend(scanner);
					}
					double lastDividend = selectedLastDividend(scanner);
					double parValue = selectedParValue(scanner);
					registerNewStock(symbol, stockType, lastDividend, fixedDividend, parValue);
					break;
				case 2:
					stock = selectedStock(scanner);
					removeStock(stock);
					break;
				case 3:
					stock = selectedStock(scanner);
					price = selectedPrice(scanner);
					calculateDividendYield(stock, price);
					break;
				case 4:
					stock = selectedStock(scanner);
					price = selectedPrice(scanner);
					calculatePERatio(stock, price);
					break;
				case 5:
					stock = selectedStock(scanner);
					int quantity = selectedQuantity(scanner);
					TradeIndicator indicator = getTradeIndicator(scanner);
					price = selectedPrice(scanner);
					recordTrade(stock, quantity, indicator, price);
					break;
				case 6:
					stock = selectedStock(scanner);
					calculateVolumeWeightedStockPrice(stock);
					break;
				case 7:
					calculateGBCE();
					break;
				case 8:
					clearAll();
					break;
				case 9:
					scanner.close();
					System.exit(0);
					break;
				default:
					break;
				}
			} catch (InvalidValueException e) {
				logMessage(e.getMessage());
			} catch (StockMarketControllerException e) {
				logMessage(e.getMessage());
			} catch (NumberFormatException e) {
				logMessage(StockMarketConstants.InvalidValueOrOption);
			} catch (Exception e) {
				logMessage(e.getMessage());
			}
			showMenu();

		} while (true);
	}

}
