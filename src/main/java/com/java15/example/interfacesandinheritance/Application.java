package com.java15.example.interfacesandinheritance;

import java.util.function.Consumer;

/**
 * https://docs.oracle.com/javase/tutorial/java/IandI/index.html
 */
public class Application {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        DemoInterface demoInterface = null;
        demoInterface = new DemoInterfaceImplV1();
        consumer.accept(demoInterface.msg("world"));
        demoInterface = new DemoInterfaceImplV2();
        consumer.accept(demoInterface.msg("world"));
    }
}
