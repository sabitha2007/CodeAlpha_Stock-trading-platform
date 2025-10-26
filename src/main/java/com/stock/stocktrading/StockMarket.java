package com.stock.stocktrading;

import java.util.*;

public class StockMarket {
    private List<Stock> stocks = new ArrayList<>();
    private Random random = new Random();

    public StockMarket() {
        stocks.add(new Stock("AAPL", 185.50));
        stocks.add(new Stock("GOOG", 2720.80));
        stocks.add(new Stock("TSLA", 980.25));
        stocks.add(new Stock("AMZN", 3400.30));
        stocks.add(new Stock("MSFT", 300.10));
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public Stock getStockBySymbol(String symbol) {
        for (Stock s : stocks) {
            if (s.getSymbol().equalsIgnoreCase(symbol)) {
                return s;
            }
        }
        return null;
    }

    // Simulate price changes
    public void updatePrices() {
        for (Stock s : stocks) {
            double change = (random.nextDouble() - 0.5) * 10; // small fluctuation
            double newPrice = Math.max(1, s.getPrice() + change);
            s.setPrice(newPrice);
        }
    }

    public void displayMarket() {
        System.out.println("\n=== Current Market Prices ===");
        for (Stock s : stocks) {
            System.out.println(s);
        }
    }
}
