package com.java15.example.sealed;

import java.util.concurrent.Callable;

/**
 * https://docs.oracle.com/en/java/javase/15/language/sealed-classes-and-interfaces.html
 */
public sealed class EShape implements Callable permits com.java15.external.ERectangle  {
    @Override
    public Object call() throws Exception {
        return "Hello World!";
    }
}
