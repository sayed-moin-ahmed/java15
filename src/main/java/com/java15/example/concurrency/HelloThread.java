package com.java15.example.concurrency;

import static java.lang.Thread.sleep;

public class HelloThread implements Runnable{
    public void run(){
        try {
            sleep(100);
        } catch (InterruptedException e) {
           System.out.println("Thread Name::"+Thread.currentThread().getName()+" InterruptedException::"+e.getMessage());
        }
    }
}
