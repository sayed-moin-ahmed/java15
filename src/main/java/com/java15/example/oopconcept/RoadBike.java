package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html
 */
public class RoadBike extends ACMEBicycle {
    public String show(){
        String msg = """
                This is RoadBike...
                """;
        System.out.println(msg);
        return msg;
    }
}
