package com.codecool.trader.service;

import com.codecool.trader.logger.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {

	private final StockAPIService stockService;
	private final Logger logger;

	@Autowired
	public Trader(StockAPIService stockService, Logger logger) {
		this.stockService = stockService;
		this.logger = logger;
	}

	/** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
	 * 	@return whether any stock was bought */
	public String buy(String symbol, double bid) throws IOException, JSONException {
		double price = stockService.getPrice(symbol);

        String result;
		if (price <= bid) {
			stockService.buy(symbol);
			result = "Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")";
		}
		else {
			result = "Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.";
		}
		logger.log(result);
		return result;
	}

}