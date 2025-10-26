package com.stock.stocktrading;

public class User {
    private String name;
    private Portfolio portfolio;

    public User(String name, double initialBalance) {
        this.name = name;
        this.portfolio = new Portfolio(initialBalance);
    }

    public String getName() {
        return name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
