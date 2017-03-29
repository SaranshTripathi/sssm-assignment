# sssm-assignment

A simple stock market application to manage stocks, trades and provide fuctionalities to calculate
 <b>For a given stock</b>
1. Given any price as input, calculate the dividend yield
2. Given any price as input, calculate the P/E Ratio
3. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
4. Calculate Volume Weighted Stock Price based on trades in past 15 minutes</br>
 <b>For Stocks</b>
1. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks.

# Assumption:

Assuming "Dividend" same as the "Last Dividend" in the "P/E Ratio" formula.

# Version
Java 1.8, 
maven compiler 3.6.1

# How to run
  Using Eclipse:
  
  Download the project assignment-sssm and import the project in Eclipse as a maven project. Run maven clean install to generate the
  executable jar (target/assignment-sssm-0.0.1-SNAPSHOT.jar) or run the Main class StockMarketController.java
  
  Using cmd prompt/terminal:
  
  Download the project assignment-sssm. Run maven clean install to generate the executable jar (assignment-sssm-0.0.1-SNAPSHOT.jar). 
  Run the executable jar using commond: java -jar target/assignment-sssm-0.0.1-SNAPSHOT.jar
