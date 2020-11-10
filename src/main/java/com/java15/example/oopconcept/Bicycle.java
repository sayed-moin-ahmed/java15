package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
 * Implementing an interface allows a class to become more formal about the behavior it promises to provide.
 * Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler.
 * If your class claims to implement an interface, all methods defined by that interface must appear in its source code before the class will successfully compile.
 */
public interface Bicycle {
    public void changeGear();

    public void changePedalCadence();

    public void changeCurrentSpeed();
}
