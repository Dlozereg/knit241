package org.knit.solutions.Task2_9_Classes;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable{
    private int lastDetailID;
    private final BlockingQueue<Detail> stampingQueue;

    public Stamper(BlockingQueue<Detail> stampingQueue) {
        this.stampingQueue = stampingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                int id = ++lastDetailID;
                Thread.sleep(1000);
                stampingQueue.put(new Detail(id));
                System.out.println("stamped detail" + id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Stumper finished");
    }
}
