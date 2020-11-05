package com.java15.example.sealed;

import java.util.concurrent.*;

public final class PrivateSealed extends Demo{

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit((Runnable) new Demo());
    }
}


sealed class Demo implements Runnable, Callable<Demo> permits PrivateSealed{

    @Override
    public void run() {
        System.out.println("Hello");
    }

    @Override
    public Demo call() throws Exception {
        return this;
    }
}