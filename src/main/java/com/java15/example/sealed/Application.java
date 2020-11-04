package com.java15.example.sealed;

import com.java15.example.unsealed.ConcreteFilledRectangle;

/**
 * https://docs.oracle.com/en/java/javase/15/language/sealed-classes-and-interfaces.html
 */
public class Application {
    public static void main(String[] args){
        System.out.println(new FilledRectangle(1,2,3,4,5));
    }
}
