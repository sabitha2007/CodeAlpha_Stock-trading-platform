package com.stock.stocktrading;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double balance;
    private Map<String, Integer> holdings = new HashMap<>();

    public Portfolio(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        if (totalCost > balance) {
            System.out.println("Not enough balance to buy " + quantity + " shares of " + stock.getSymbol());
            return;
        }

        balance -= totalCost;
        holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
        System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
    }

    public void sellStock(Stock stock, int quantity) {
        int currentQuantity = holdings.getOrDefault(stock.getSymbol(), 0);
        if (quantity > currentQuantity) {
            System.out.println("You don’t own that many shares of " + stock.getSymbol());
            return;
        }

        balance += stock.getPrice() * quantity;
        holdings.put(stock.getSymbol(), currentQuantity - quantity);
        if (holdings.get(stock.getSymbol()) == 0) holdings.remove(stock.getSymbol());
        System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
    }

    public void displayPortfolio() {
        System.out.println("\n=== Portfolio Summary ===");
        System.out.printf("Current Balance: $%.2f\n", balance);
        if (holdings.isEmpty()) {
            System.out.println("No holdings yet.");
            return;
        }
        System.out.println("Stock\tQuantity");
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public void saveToFile(String username) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("portfolios.txt", true))) {
            bw.write("User: " + username + "\nBalance: " + balance + "\nHoldings: " + holdings + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
