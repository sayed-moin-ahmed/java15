package com.java15.external;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        String future = (String) service.submit(new ERectangle("Demo")).get();
        System.out.println(future);
        service.shutdown();
    }
}
