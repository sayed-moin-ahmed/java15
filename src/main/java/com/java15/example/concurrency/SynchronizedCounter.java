package com.java15.example.concurrency;

public class SynchronizedCounter implements ICounter {
    private int c = 0;

    SynchronizedCounter(){
    }

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
