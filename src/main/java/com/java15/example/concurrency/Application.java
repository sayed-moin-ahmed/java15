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
            if(Thread.interrupted()) //works of current thread(static) clear interrupt status
                return;
        }
    }

    private static void instanceInterrupt() throws InterruptedException {
        while(true) {
            Thread thread = new HelloThread();
            thread.start();
            if(!thread.isInterrupted())
                System.out.println("Thread Name::"+thread.getName()+" not interrupted."); //instance interruption check
            thread.join();
            thread.interrupt();
            if(thread.isInterrupted()) //works of current thread(static)
                System.out.println("Thread Name::"+thread.getName()+" is interrupted."); //instance interruption check
        }
    }
}
