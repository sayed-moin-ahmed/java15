package com.java15.example.collections;

import java.util.Queue;
import java.util.UUID;

public class QueueOfferDemo implements Runnable{
    final private Queue<? super String> queue;

    QueueOfferDemo(Queue<? super String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.offer("Hello" + UUID.randomUUID());
        }
    }
}