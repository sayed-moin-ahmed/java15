package com.java15.example.concurrency1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* FutureTask<String> futureTask = new FutureTask<>(new CallableImpl());
        Thread thread = new Thread(futureTask);
        thread.start();
        Thread.sleep(100);
        System.out.println(futureTask.get());*/
        streamDemo();
    }


    static public void streamDemo(){
        UnaryOperator<String> lowerCase =  String::toLowerCase;
        //Stream.generate(()->"Hello World!").forEach(System.out::println);
        Stream.iterate("Hello World!",lowerCase).forEach(System.out::println);
        
    }
}
