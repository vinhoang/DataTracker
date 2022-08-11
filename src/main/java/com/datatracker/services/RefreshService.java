package com.datatracker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static com.datatracker.utilities.Constants.refreshInterval;


/**
 * This service is to update price every minute (cron job)
 * Get data from stockService and update db via dbservice
 */
@Service
@RequiredArgsConstructor
@EnableAsync
public class RefreshService {

    private final dbService dbservice;
    private final YahooStockService stockService;
    private final Set<String> tickers = new HashSet<>();

    public void add(String tickerName) {
        tickers.add(tickerName);
    }

    @Async
    @Scheduled(fixedRate = refreshInterval)
    public void update() throws IOException {
        for (String ticker : tickers) {
            BigDecimal price = stockService.getQuote(ticker);
            if (price == null) continue;
            dbservice.put(ticker, price);
        }
    }
}
