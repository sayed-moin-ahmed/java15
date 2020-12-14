package com.java15.example.numbersandstrings;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://www.gotw.ca/publications/c_family_interview.htm
 */
public class Application {
    public static void main(String[] args) {
        //numbers();
        atomicInt();
    }

    private static void atomicInt() {
        Runnable r  = new Runnable() {
            AtomicInteger ai1 = new AtomicInteger();
            AtomicInteger ai2 = new AtomicInteger();

            @Override
            public void run() {
                System.out.println("Increment and Get ::"+ai1.incrementAndGet());
                System.out.println("Fetch value and Increment::"+ai2.getAndIncrement());
            }
        };
        Thread thread1 = new Thread(r);
        thread1.start();
        Thread thread2 = new Thread(r);
        thread2.start();
    }

    private static void numbers() {
        Number integerValue = 5;
        Number floatValue = 5.5;
        Number doubleValue = 5.6777888888;
        System.out.println(integerValue+"::"+floatValue+"::"+doubleValue);
        System.out.println(integerValue.byteValue());
        System.out.println(integerValue.shortValue());
        System.out.println(integerValue.longValue());
        System.out.println(integerValue.floatValue());
        System.out.println(integerValue.doubleValue());
        System.out.println(integerValue.toString());

        System.out.println(doubleValue.byteValue());
        System.out.println(doubleValue.shortValue());
        System.out.println(integerValue.intValue());
        System.out.println(doubleValue.longValue());
        System.out.println(doubleValue.floatValue());
        System.out.println(integerValue.toString());

        Integer value1 = 5;
        Integer value2 = 5;
        System.out.println("Compared values : "+value1.compareTo(value2));
        System.out.println("Decode::"+Integer.decode("23"));
        System.out.println("Parse Int::"+Integer.parseInt("23"));
        System.out.println("Value Of::"+Integer.valueOf("23"));
    }
}
