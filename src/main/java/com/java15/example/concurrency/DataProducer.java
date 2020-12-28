package com.java15.example.concurrency;

import java.util.Random;

public class DataProducer implements  Runnable{

    private final Data data;

    DataProducer(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            data.setMessage(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        data.setMessage("DONE");
    }
}
