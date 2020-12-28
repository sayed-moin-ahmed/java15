package com.java15.example.concurrency;

import java.util.Random;

public class DataConsumer implements  Runnable{

    private final Data data;

    DataConsumer(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String message = data.getMessage(); ! message.equals("DONE"); message = data.getMessage()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
