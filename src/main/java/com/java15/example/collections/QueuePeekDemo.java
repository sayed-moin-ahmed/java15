package com.java15.example.collections;

import java.util.Queue;

public class QueuePeekDemo implements Runnable{
    final private Queue<? super String> queue;
    QueuePeekDemo(Queue<? super String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.peek();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}