package com.java15.example.concurrency;

public class DecrementCounterRunnable implements  Runnable{
    private final ICounter icounter;

    public DecrementCounterRunnable(ICounter icounter){
        this.icounter = icounter;
    }
    @Override
    public void run() {
        icounter.decrement();
        System.out.println(icounter.getClass()+"@dec::"+icounter.value());
    }
}
