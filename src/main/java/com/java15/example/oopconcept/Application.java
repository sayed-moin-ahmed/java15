package com.java15.example.oopconcept;


/**
 * blueprint or prototype
 * https://docs.oracle.com/javase/tutorial/java/concepts/object.html
 */
public class Application {
    public static void main(String[] args) {
        dataEncapsulation();
        Bicycle cycle = new MountainBikes("Sam");
        //Uncomment below line - Bicycle is not aware of show method as its defined in sub class
        /*bicycle.show();*/
        System.out.println(cycle);
        cycle.changePedalCadence();
        cycle.changeCurrentSpeed();
        cycle.changeGear();
        System.out.println(cycle);

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
