package com.java15.example.record;

import java.util.concurrent.Callable;

abstract class AbstractRecord {
    abstract String show();
}

/**
 * https://docs.oracle.com/en/java/javase/15/language/records.html
 * works like immutable class , records can be public or package-private(default)
 * class is final , final parameters, implements interface
 */
public record Rectangle(double height, double width) implements Callable {
    @Override
    public String call() throws Exception {
        return "Hello! Area::"+(height*width);
    }
}
