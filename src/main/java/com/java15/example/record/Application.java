package com.java15.example.record;

import com.java15.example.sealed.TopInterface;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        String future = (String) service.submit(new Rectangle(10,10)).get();
        service.submit(new WithoutParam());
        System.out.println(future);
        System.out.println(new WithParam("Test"));
        service.shutdown();
        needToCheckAnnymousSealedInterface();
    }

    private static void needToCheckAnnymousSealedInterface() {
        //Need to check
        /*TopInterface annymous = new TopInterface(){

            @Override
            public String show() {
                return null;
            }
        };*/
    }
}
