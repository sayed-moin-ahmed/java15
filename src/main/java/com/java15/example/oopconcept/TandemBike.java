package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html
 */
public class TandemBike extends Bicycle {
    public String show(){
        String msg = """
                This is TandemBike...
                """;
        System.out.println(msg);
        return msg;
    }
}
