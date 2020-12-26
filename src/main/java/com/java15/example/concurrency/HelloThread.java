package com.java15.example.concurrency;

import static java.lang.Thread.sleep;

public class HelloThread extends Thread{

    public void run(){
        try {
            sleep(100);
        } catch (InterruptedException e) {
           System.out.println("Thread Name::"+currentThread().getName()+" InterruptedException::"+e.getMessage());
        }
    }

}
