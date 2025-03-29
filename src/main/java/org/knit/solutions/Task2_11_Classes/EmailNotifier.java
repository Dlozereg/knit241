package org.knit.solutions.Task2_11_Classes;

import java.util.ArrayList;
import java.util.List;

public class EmailNotifier implements StockObserver{
    private final List<Stock> subscriptions = new ArrayList<>();

    public void subscribe(Stock stock) {
        subscriptions.add(stock);
        stock.addObserver(this);
    }

    public void unsubscribe(Stock stock) {
        subscriptions.remove(stock);
        stock.removeObserver(this);
    }

    public void getSubscriptions() {
        if (!subscriptions.isEmpty()) {
            for (Stock stock : subscriptions) {
                System.out.println("Stock: " + stock.getName() + "\tcurrent price: " + stock.getPrice());
            }
        }
        else {
            System.out.println("There are no subscribtions");
        }
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Email: Stock \"" + stock.getName() + "\" changed its price to "
                            + stock.getPrice());
    }
}
