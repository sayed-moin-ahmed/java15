package com.java15.example.record;

import com.java15.example.sealed.SubTopInterface;

import java.util.concurrent.Callable;

abstract class AbstractRecord {
    abstract String show();
}

/**
 * https://docs.oracle.com/en/java/javase/15/language/records.html
 * works like immutable class , records can be public or package-private(default)
 * class is final , final parameters, implements interface
 * Extends interface,sealed interface
 */
public record Rectangle(double height, double width) implements Callable, SubTopInterface {
    public Rectangle {
        if (height <= 0 || width <= 0) {
            throw new java.lang.IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", height, width));
        }
    }

    @Override
    public String call() throws Exception {
        return "Hello! Area::"+(height*width);
    }
}


record WithoutParam() implements Runnable{
    //Constructor same as WithoutParam()
    public WithoutParam(){
        System.out.println("Initializing without Param Constructor...");
    }

    @Override
    public void run() {
        System.out.println("Demo");
    }
}

/**
 * This succinct form of constructor declaration is only available in a record class.
 * Note that the statements this.length = length; and this.width = width; which appear in the canonical constructor do not appear in the compact constructor.
 * At the end of a compact constructor, its implicit formal parameters are assigned to the record class's private fields corresponding to its components.
 */
record WithParam(String value) {
    //Constructor same as WithoutParam()
    public WithParam(String value){
        System.out.println("Initializing without Param Constructor...");
        this.value = value; //Need
    }
}