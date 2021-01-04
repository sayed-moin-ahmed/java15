package com.java15.example.collections;

import java.util.Queue;

public class QueueRemoveDemo implements Runnable{
    final private Queue<? super String> queue;
    QueueRemoveDemo(Queue<? super String> queue){
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
            queue.remove();

        }
    }
}