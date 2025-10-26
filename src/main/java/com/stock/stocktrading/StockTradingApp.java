package com.mathan.stocktrading;

import java.util.Scanner;

public class StockTradingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockMarket market = new StockMarket();

        System.out.println("=== Welcome Stock Trading Platform ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: $");
        double balance = sc.nextDouble();
        sc.nextLine(); // consume newline

        User user = new User(name, balance);

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Save Portfolio");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    market.updatePrices();
                    market.displayMarket();
                    break;
                case 2:
                    market.displayMarket();
                    System.out.print("Enter stock symbol to buy: ");
                    String symbolBuy = sc.nextLine();
                    Stock stockBuy = market.getStockBySymbol(symbolBuy);
                    if (stockBuy == null) {
                        System.out.println("Stock not found!");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qtyBuy = sc.nextInt();
                    sc.nextLine();
                    user.getPortfolio().buyStock(stockBuy, qtyBuy);
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String symbolSell = sc.nextLine();
                    Stock stockSell = market.getStockBySymbol(symbolSell);
                    if (stockSell == null) {
                        System.out.println("Stock not found!");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qtySell = sc.nextInt();
                    sc.nextLine();
                    user.getPortfolio().sellStock(stockSell, qtySell);
                    break;
                case 4:
                    user.getPortfolio().displayPortfolio();
                    break;
                case 5:
                    user.getPortfolio().saveToFile(user.getName());
                    System.out.println("Portfolio saved to file.");
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye, " + user.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
