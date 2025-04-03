package org.knit.solutions.Task2_7_Classes;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<String> itemStock;

    public Producer(BlockingQueue<String> itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            try {
                itemStock.put(Integer.toString(i));
                System.out.println("Producer produced item №" + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
