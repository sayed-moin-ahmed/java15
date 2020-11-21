package com.java15.example.classesobjects;


/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
 */
public class Application {

    public static void main(String[] args) {
        TopInterface  reference = null;
        reference = getTopInterface();
        reference.show();
        reference = getTopInterface1();
        reference.show();
    }

    private static TopInterface getTopInterface1() {
        TopInterface reference =  new CustomRecord();
        return reference;
    }

    private static TopInterface getTopInterface() {
        TopInterface reference = new CustomClass();
        return reference;
    }

}
