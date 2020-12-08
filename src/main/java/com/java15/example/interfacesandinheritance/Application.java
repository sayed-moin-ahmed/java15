package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I1;
import com.java15.example.interfacesandinheritance.i1.I12;
import com.java15.example.interfacesandinheritance.i1.I1Impl;
import com.java15.example.interfacesandinheritance.i2.I2;
import com.java15.example.interfacesandinheritance.i2.I22;
import com.java15.example.interfacesandinheritance.i2.I2Impl;

import java.util.function.Consumer;

/**
 * https://docs.oracle.com/javase/tutorial/java/IandI/index.html
 */
public class Application {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        //interfaceDemo(consumer);
        //instanceOfDemo(consumer);
        I12 i12 = new DefaultDiamondImpl();
        consumer.accept(i12.msg());
        I22 i22 = new DefaultDiamondImpl();
        consumer.accept(i22.msg());
    }

    private static void instanceOfDemo(Consumer<String> consumer) {
        I1 i1 = new I1Impl();
        I2 i2 = new I2Impl();
        if(i1 instanceof I1 var){
            consumer.accept(var.msg("Hello"," World"));
        }
    }

    private static void interfaceDemo(Consumer<String> consumer) {
        DemoInterface demoInterface = null;
        demoInterface = new DemoInterfaceImplV1();
        consumer.accept(demoInterface.msg("world","war"));
        demoInterface = new DemoInterfaceImplV2();
        consumer.accept(demoInterface.msg("world"));
    }
}
