package com.java15.example.exceptions;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html
 */
public class Application {
    public static void main(String[] args) {
        // exceptionCallStack();
        tryCatch();
    }

    //Catching More Than One Type of Exception with One Exception Handler
    private static void tryCatch() {
        try{
            exceptionCallStack();
            throw new ArrayIndexOutOfBoundsException("Array Exception");
        }catch (ArrayIndexOutOfBoundsException|IllegalArgumentException throwable){
            System.out.println(throwable.getMessage());
        }
    }

    private static void exceptionCallStack() {
        Caller caller = new Caller();
        caller.call();
    }
}
