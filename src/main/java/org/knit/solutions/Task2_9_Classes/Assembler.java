package org.knit.solutions.Task2_9_Classes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Assembler implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> assebleQueue;

    public Assembler(BlockingQueue<Detail> stampingQueue, BlockingQueue<Detail> assebleQueue) {
        this.stampingQueue = stampingQueue;
        this.assebleQueue = assebleQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = stampingQueue.poll(5000, TimeUnit.MILLISECONDS);
                if (detail != null) {
                    Thread.sleep(1500);
                    assebleQueue.put(detail);
                    System.out.println("assembled detail" + detail.getId());
                }
                else {
                    System.out.println("Assembler finished");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
