package com.java15.example.classesobjects;


/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
 */
public class Application {

    public static void main(String[] args) {
        //This technique, called covariant return type, means that the return type is allowed to vary in the same direction as the subclass.
        TopInterface  reference = null;
        reference = getTopInterface();
        reference.show();
        reference = getTopInterface1();
        reference.show();
        reference = new FunctionalInterfaceImpl();
        reference.toString();
        ((FunctionalInterfaceImpl) reference).ni.show1();
    }

    private static TopInterface getTopInterface1() {
        TopInterface reference =  new CustomRecord();
        return reference;
    }

    private static TopInterface getTopInterface() {
        TopInterface reference = new CustomClass("Hello world!");
        return reference;
    }

}
