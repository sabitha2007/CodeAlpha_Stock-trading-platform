package com.srock.stocktrading;

import java.time.LocalDateTime;

public class Trade {
    private String stockSymbol;
    private int quantity;
    private double price;
    private String type;
    private LocalDateTime timestamp;

    public Trade(String stockSymbol, int quantity, double price, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %d of %s @ $%.2f",
                timestamp, type.toUpperCase(), quantity, stockSymbol, price);
    }
}
