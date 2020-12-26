package com.java15.example.concurrency;

public class JoinThreadClass extends Thread{
    private String threadName = null;
    public JoinThreadClass(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        try {
            System.out.println("Before JoinThreadClass::"+threadName);
            Thread.sleep(200);
            System.out.println("After JoinThreadClass");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
