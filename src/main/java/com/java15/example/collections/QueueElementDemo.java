package com.java15.example.collections;

import java.util.Queue;

public class QueueElementDemo implements Runnable{
    final private Queue<? super String> queue;
    QueueElementDemo(Queue<? super String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.element();

        }
    }
}