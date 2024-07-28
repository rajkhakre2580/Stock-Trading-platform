package pack1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


	    class Stock {
	    	
		    private String symbol;
		    private double price;

		    public Stock(String symbol, double price) {
		        this.symbol = symbol;
		        this.price = price;
		    }

		    public String getSymbol() {
		        return symbol;
		    }

		    public double getPrice() {
		        return price;
		    }
		}

		public class StockTrading {
		    private Map<String, Stock> stocks;
		    private double balance;

		    public StockTrading() {
		        this.stocks = new HashMap<>();
		        this.balance = 10000.0; // initial balance
		    }

		    public void addStock(String symbol, double price) {
		        stocks.put(symbol, new Stock(symbol, price));
		    }

		    public void buyStock(String symbol, int quantity) {
		        if (stocks.containsKey(symbol)) {
		            Stock stock = stocks.get(symbol);
		            double totalCost = stock.getPrice() * quantity;
		            if (balance >= totalCost) {
		                balance -= totalCost;
		                System.out.println("Bought " + quantity + " shares of " + symbol + " at $" + stock.getPrice() + " each.");
		            } else {
		                System.out.println("Insufficient balance.");
		            }
		        } else {
		            System.out.println("Stock not found.");
		        }
		    }

		  public void sellStock(String symbol, int quantity) {
		        if (stocks.containsKey(symbol)) {
		            Stock stock = stocks.get(symbol);
		            double totalRevenue = stock.getPrice() * quantity;
		            balance += totalRevenue;
		            System.out.println("Sold " + quantity + " shares of " + symbol + " at $" + stock.getPrice() + " each.");
		        } 
		        else {
		            System.out.println("Stock not found.");
		        }
		    
		  }
		    public void displayBalance() {
		        System.out.println("Current balance: $" + balance);}
		    

		    public static void main(String[] args) {
		        StockTrading platform = new StockTrading();
		        platform.addStock("AAPL", 150.0);
		        platform.addStock("GOOG", 2500.0);

		        Scanner scanner = new Scanner(System.in);
		        while (true) {
		            System.out.println("1. Buy stock");
		            System.out.println("2. Sell stock");
		            System.out.println("3. Display balance");
		            System.out.println("4. Exit");
		            System.out.print("Choose an option: ");
		            int option = scanner.nextInt();
		            switch (option) {
		                case 1:
		                    System.out.print("Enter stock symbol: ");
		                    String symbol = scanner.next();
		                    System.out.print("Enter quantity: ");
		                    int quantity = scanner.nextInt();
		                    platform.buyStock(symbol, quantity);
		                    break;
		                case 2:
		                    System.out.print("Enter stock symbol: ");
		                    symbol = scanner.next();
		                    System.out.print("Enter quantity: ");
		                    quantity = scanner.nextInt();
		                    platform.sellStock(symbol, quantity);
		                    break;
		                case 3:
		                    platform.displayBalance();
		                    break;
		                case 4:
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Invalid option.");
		            }
		        }
		    }
		    }
		    


