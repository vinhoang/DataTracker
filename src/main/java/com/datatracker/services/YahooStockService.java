package com.datatracker.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@AllArgsConstructor
@Service
/**
 * This service is to get stock price from Yahoo
 */
public class YahooStockService {

    public BigDecimal getQuote(final String ticker) throws IOException {
        Stock stock = getStock(ticker);
        if (stock == null) {
            return null;
        }
        return stock.getQuote().getPrice();
    }

    private Stock getStock(final String ticker) throws IOException {
        return YahooFinance.get(ticker);
    }
}
