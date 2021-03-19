package com.java15.example.concurrency1;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World";
    }
}
