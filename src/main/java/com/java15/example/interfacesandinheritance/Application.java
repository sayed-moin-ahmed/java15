package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I1;
import com.java15.example.interfacesandinheritance.i1.I12;
import com.java15.example.interfacesandinheritance.i1.I1Impl;
import com.java15.example.interfacesandinheritance.i2.I2;
import com.java15.example.interfacesandinheritance.i2.I22;
import com.java15.example.interfacesandinheritance.i2.I2Impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.Class.forName;

/**
 * https://docs.oracle.com/javase/tutorial/java/IandI/index.html
 */
public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        Consumer<String> consumer = System.out::println;
        //interfaceDemo(consumer);
        //instanceOfDemo(consumer);
        //defaultInheritance(consumer);
        //staticMethods(consumer);
        //sort();
        //customSort();
        cloning();
    }

    private static void cloning() throws ClassNotFoundException {
        ObjectAsSuperclass objectAsSuperclass = new ObjectAsSuperclass(22,"sam");
        try {
            if (objectAsSuperclass.clone() instanceof ObjectAsSuperclass cloned) {
                System.out.println(cloned);
                cloned.setName("Rocky");
                System.out.println(objectAsSuperclass);
                System.out.println(cloned);
            }
        }catch (CloneNotSupportedException cloneNotSupportedException){
            System.out.println(cloneNotSupportedException.getMessage());
        }
    }

    private static void customSort() {
        StandardDeck standardDeck = new StandardDeck();
        standardDeck.sort(Comparator.comparing(Card::getValue).thenComparing(Comparator.comparing(Card::getSuits)));
    }

    private static void sort() {
        List<String> list = new ArrayList<>();
        list.add("sayed");
        list.add("ahmed");
        Collections.sort(list,I2::compare);
    }

    private static void staticMethods(Consumer<String> consumer) {
        consumer.accept(I1.msg());
        consumer.accept(I2.msg());
    }

    private static void defaultInheritance(Consumer<String> consumer) {
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
        consumer.accept(demoInterface.msg());
        demoInterface = new DemoInterfaceImplV2();
        consumer.accept(demoInterface.msg());
    }

}
