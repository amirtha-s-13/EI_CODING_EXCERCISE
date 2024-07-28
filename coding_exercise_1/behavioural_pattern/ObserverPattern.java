// Observer Pattern

import java.util.ArrayList;
import java.util.List;

class Stock {
    private String name;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(name, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

interface StockObserver {
    void update(String stockName, double stockPrice);
}

class ConcreteStockObserver implements StockObserver {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("StockObserver: " + stockName + " price updated to " + stockPrice);
    }
}

// Usage
public class ObserverPattern {
    public static void main(String[] args) {
        Stock apple = new Stock("Apple", 150.00);
        StockObserver observer1 = new ConcreteStockObserver();
        StockObserver observer2 = new ConcreteStockObserver();

        apple.registerObserver(observer1);
        apple.registerObserver(observer2);

        apple.setPrice(155.00);
        apple.setPrice(160.00);
    }
}
