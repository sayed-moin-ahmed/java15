package com.java15.example.record;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        String future = (String) service.submit(new Rectangle(10,10)).get();
        System.out.println(future);
        service.shutdown();
    }
}
