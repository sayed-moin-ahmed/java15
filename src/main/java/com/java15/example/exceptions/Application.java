package com.java15.example.exceptions;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html
 */
public class Application {
    public static void main(String[] args) {
        // exceptionCallStack();
        // tryCatch();
        System.out.println(returnStatementWithExceptionDemo());
    }

    //Catching More Than One Type of Exception with One Exception Handler
    /**
     * Note: If a catch block handles more than one exception type, then the catch parameter is implicitly final.
     * In this example, the catch parameter ex is final and therefore you cannot assign any values to it within the catch block.
     */
    private static void tryCatch() {
        try{
            exceptionCallStack();
            throw new ArrayIndexOutOfBoundsException("Array Exception");
        }catch (ArrayIndexOutOfBoundsException|IllegalArgumentException throwable){
            System.out.println(throwable.getMessage());
        }
    }

    private static String returnStatement(){
        try{
            return "Hello World!";
        }catch (Exception e) {
            System.out.println("Exception...");
            return e.getMessage();
        }
    }

    //finally will override the return of normal try block
    private static String returnStatmentFinallyDemo(){
        try{
            return "Hello World!";
        }catch (Exception e){
            System.out.println("Exception...");
            return e.getMessage();
        }finally {
            return "finally...";
        }
    }

    private static String returnStatementWithExceptionDemo(){
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
            return e.getMessage();
        }
    }

    //finally will override the return of catch block
    private static String returnStatementWithExceptionFinallyDemo(){
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
            return e.getMessage();
        }finally {
            return "finally...";
        }
    }

    private static void exceptionCallStack() {
        Caller caller = new Caller();
        caller.call();
    }
}
