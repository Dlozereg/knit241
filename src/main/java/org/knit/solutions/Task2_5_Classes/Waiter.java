package org.knit.solutions.Task2_5_Classes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Waiter implements Runnable {
    private final BlockingQueue<String> dishes;

    public Waiter(BlockingQueue<String> dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String dish = dishes.poll(5000, TimeUnit.MILLISECONDS);
                if (dish != null) {
                    System.out.println("Официант принял блюдо " + dish);
                    Thread.sleep(3000);
                } else {
                    System.out.println("Официант не дождался блюда, конец смены");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
