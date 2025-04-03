package org.knit.solutions.Task2_5_Classes;

import java.util.concurrent.BlockingQueue;

public class Cook implements Runnable {
    private final BlockingQueue<String> dishes;

    public Cook(BlockingQueue<String> dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 8; i++) {
            try {
                dishes.put("Блюдо " + i);
                System.out.println("Повар приготовил блюдо " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
