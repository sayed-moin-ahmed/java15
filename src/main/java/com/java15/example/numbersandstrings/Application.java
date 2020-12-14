package com.java15.example.numbersandstrings;

/**
 * http://www.gotw.ca/publications/c_family_interview.htm
 */
public class Application {
    public static void main(String[] args) {
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
    }
}
