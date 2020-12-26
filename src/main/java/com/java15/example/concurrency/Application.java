package com.java15.example.concurrency;

public class Application{

    public static void main(String[] args) throws InterruptedException {
        //staticInterrupt();
        instanceInterrupt();
    }

    private static void staticInterrupt() throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0;i < importantInfo.length;i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
            if(Thread.interrupted()) //works of current thread(static)
                return;
        }
    }

    private static void instanceInterrupt() {
        while(true) {
            Thread thread = new HelloThread();
            thread.start();
            System.out.println("Thread Name::"+thread.getName()+" Thread interrupted::"+thread.isInterrupted()); //instance interruption check
            thread.interrupt();
            System.out.println("Thread Name::"+thread.getName()+" Thread interrupted::"+thread.isInterrupted()); //instance interruption check
        }
    }
}
