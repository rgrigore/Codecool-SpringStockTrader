package com.codecool.trader.controller;

import com.codecool.trader.logger.Logger;
import com.codecool.trader.service.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/buy/*")
public class BuyController {

    private static final String ERROR_MSG = "There was an error while attempting to buy the stock: %s";

    private final Trader trader;
    private final Logger logger;

    @Autowired
    public BuyController(Trader trader, Logger logger) {
        this.trader = trader;
        this.logger = logger;
    }

    @GetMapping("/{stock}/{price}")
    @ResponseBody
    public String buy(@PathVariable("stock") String stock, @PathVariable("price") Integer price) {
        try {
			return trader.buy(stock, price);
		} catch (Exception e) {
            String error = String.format(ERROR_MSG, e.getMessage());
			logger.log(error);
			return error;
		}
    }
}
