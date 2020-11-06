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

    // Static field
    static double goldenRatio;

    // Static initializer
    static {
        goldenRatio = (1 + Math.sqrt(5)) / 2;
    }

    // Static method
    public static Rectangle createGoldenRectangle(double width) {
        return new Rectangle(width, width * goldenRatio);
    }

    public Rectangle {
        if (height <= 0 || width <= 0) {
            throw new java.lang.IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", height, width));
        }
    }

    @Override
    public String call() throws Exception {
        System.out.println(createGoldenRectangle(width));
        WithoutParam.InnerPublicRecord wipr = new WithoutParam.InnerPublicRecord();
        return "Hello! Area::"+(height*width);
    }
}


record WithoutParam() implements Runnable{
    //Constructor same as WithoutParam()
    public WithoutParam(){
        System.out.println("Initializing without Param Constructor...");
        InnerPrivateRecord ir = new InnerPrivateRecord();
    }

    @Override
    public void run() {
        System.out.println("Demo");
    }

    private record InnerPrivateRecord() {
        InnerPrivateRecord {
            System.out.println("Private inner record Record");
        }
    }

    public record InnerPublicRecord() {
        public InnerPublicRecord {
            System.out.println("public inner record Record");
        }
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