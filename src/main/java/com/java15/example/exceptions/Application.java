package com.java15.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html
 */
public class Application {
    public static void main(String[] args) {
        // exceptionCallStack();
        // tryCatch();
        continueStatmentFinally();
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

    private static void continueStatmentFinally(){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,0);
        //break,continue, return (value) is not allowed in internal loops
        list.forEach(e->{
            if(5==e){
                return ;
            }
        });

        System.out.println("Loop external");
        int counter = 0;
        try {
            for(Integer e : list){
                if(5==e){
                    continue;
                }
                counter++;
                throw new ArrayIndexOutOfBoundsException("");
            }
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("continue::catch");
        }
        System.out.println("Counter::"+counter);
    }

    /**
     * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
     * @param path
     * @return
     * @throws IOException
     */
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =  new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }



}
