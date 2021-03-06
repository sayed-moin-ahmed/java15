package com.java15.example.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Reference to be checked:
 * https://docs.oracle.com/javase/specs/jls/se15/html/jls-17.html#jls-17.4.5
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/concurrent/package-summary.html
 */
public class Application{

    public static void main(String[] args) throws InterruptedException {
        //staticInterrupt();
        //instanceInterrupt();
        //interruptDemo();
        //producerConsumer();
        List<String> addresses = new ArrayList<>();
        addresses.add("US");
        addresses.add("UK");
        ImmutableClass immutableClass = ImmutableClass.getInstance("sam",31,addresses);
        System.out.println(immutableClass);
        addresses.add("Sweden");
        System.out.println(immutableClass);
        System.out.println(addresses);
    }

    private static void producerConsumer() {
        Data drop = new Data();
        (new Thread(new DataProducer(drop))).start();
        (new Thread(new DataConsumer(drop))).start();
    }

    private static void interruptDemo() {
        Counter counter = new Counter();
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        while(true){
            new Thread(new IncrementCounterRunnable(counter)).start();
            new Thread(new DecrementCounterRunnable(counter)).start();
            new Thread(new IncrementCounterRunnable(synchronizedCounter)).start();
            new Thread(new DecrementCounterRunnable(synchronizedCounter)).start();
        }
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
            Thread thread = new Thread(new HelloThread());
            thread.start();
            if(!thread.isInterrupted())
                System.out.println("Thread Name::"+thread.getName()+" not interrupted."); //instance interruption check
            JoinThreadClass joinThreadClass = new JoinThreadClass(thread.getName());
            joinThreadClass.start();
            joinThreadClass.join();
            thread.interrupt();
            if(thread.isInterrupted()) //works of current thread(static)
                System.out.println("Thread Name::"+thread.getName()+" is interrupted."); //instance interruption check
        }
    }
}
