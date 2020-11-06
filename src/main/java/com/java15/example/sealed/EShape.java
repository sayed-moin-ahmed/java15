package com.java15.example.sealed;

import java.util.concurrent.Callable;

/**
 * https://docs.oracle.com/en/java/javase/15/language/sealed-classes-and-interfaces.html
 * permits in other package
 */
public sealed class EShape implements Callable permits com.java15.external.ERectangle  {
    private String name;
    public EShape(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return String.format("Hello World %s!",name);
    }
}
