package com.java15.example.concurrency;

public class IncrementCounterRunnable implements  Runnable{
    private final ICounter icounter;

    public IncrementCounterRunnable(ICounter icounter){
        this.icounter = icounter;
    }
    @Override
    public void run() {
        icounter.increment();
        System.out.println(icounter.getClass()+"@inc::"+icounter.value());
    }
}
