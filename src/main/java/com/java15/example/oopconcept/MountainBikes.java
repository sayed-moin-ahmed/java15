package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html
 */
public class MountainBikes extends ACMEBicycle {

    public MountainBikes(){}

    protected MountainBikes(String owner){
        this.owner = owner;
    }

    public String show(){
        String msg = """
                This is MountainBike...
                """;
        System.out.println(msg);
        return msg;
    }

}
