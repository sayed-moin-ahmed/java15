package com.java15.example.numbersandstrings;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Formatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://www.gotw.ca/publications/c_family_interview.htm
 */
public class Application {
    public static void main(String[] args) {
        //numbers();
        //atomicInt();
        //formatValues();
        //decimalFormat();
        //beyondBasicArithmetic();
        stringSplitDemo();
    }

    public  static  void beyondBasicArithmetic(){
        System.out.println(Math.cos(10));
        System.out.println(Math.ceil(10.10));
        System.out.println(Math.floor(10.10));
        System.out.println(Math.rint(10));
        System.out.println(Math.round(10.11));
        System.out.println(Math.min(10.11,10.12));
        System.out.println(Math.max(10.11,10.12));
        System.out.print(Math.random());
    }

    private static void decimalFormat() {
        String pattern ="###,###.###";
        NumberFormat numberFormat = new DecimalFormat(pattern);
        numberFormat.setMaximumFractionDigits(2);
        String test = numberFormat.format(1234567890.123);
        numberFormat.parse("10.20",new ParsePosition(2));
        System.out.println(test);
    }

    private static void formatValues() {
        System.out.format("The value is %s",10);
        System.out.format("The value is %d",10);
        System.out.format("The value is %f",10.5f);
        System.out.printf("Demo Program %s","Hello");
        System.out.format("The data is %s","Hello");
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

    public static void stringDemo(){
        char[] helloArray = {'h','e','l','l','o'};
        String helloString = new String(helloArray);
        System.out.println(helloString);
        System.out.println(helloString.length());
        String.format("The value is %b",true);
        System.out.format("The value is %b",true);
        System.out.printf("The value is %b",true);
    }

    public static void stringSplitDemo(){
        String anotherPalindrome = "Niagara. O roar again!";
        char aChar = anotherPalindrome.charAt(9);
        System.out.println("0-3: "+anotherPalindrome.substring(0,3));
        System.out.println("9: "+anotherPalindrome.substring(9));
        for(var str : anotherPalindrome.split(" ")){
            System.out.println("Split: "+str);
        }

        for(var str : anotherPalindrome.split(" ",2)){
            System.out.println("Split with limit: "+str);
        }
        var str = "Hello! This is world.txt";
        System.out.println(str.endsWith(".txt"));
        System.out.println(str.startsWith("Hello"));
        System.out.println(str.compareTo("Hello"));
        System.out.println(str.matches("This is world"));
    }



}
