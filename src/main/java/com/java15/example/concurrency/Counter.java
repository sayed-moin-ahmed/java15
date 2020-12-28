package com.java15.example.concurrency;

public class Counter implements ICounter {
    private int c = 0;

    Counter(){
    }

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "c=" + c +
                '}';
    }
}
