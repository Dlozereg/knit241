package org.knit.solutions.Task2_7_Classes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    BlockingQueue<String> itemStock;

    public Consumer(BlockingQueue<String> itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String item = itemStock.poll(3000, TimeUnit.MILLISECONDS);
                if (item != null) {
                    System.out.println("Consumer consumed item №" + item);
                    Thread.sleep(1500);
                }
                else {
                    System.out.println("Consumer left");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
