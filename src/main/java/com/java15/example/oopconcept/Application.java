package com.java15.example.oopconcept;


/**
 * blueprint or prototype
 * https://docs.oracle.com/javase/tutorial/java/concepts/object.html
 */
public class Application {
    public static void main(String[] args) {
        dataEncapsulation();
    }

    private static void dataEncapsulation() {
        Bicycle cycle  = new Bicycle();
        System.out.println(cycle);
        cycle.changePedalCadence();
        cycle.changeCurrentSpeed();
        cycle.changeGear();
        System.out.println(cycle);
    }
}
