package com.java15.example.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    private String value = "";
    private final Lock lock = new ReentrantLock();
    public Locks(final String value){
        this.value = value;
    }

    public String modify(String concat){
        if(lock.tryLock()) {
            value = value.concat(concat);
        }
        lock.unlock();
        return value;
    }



}
