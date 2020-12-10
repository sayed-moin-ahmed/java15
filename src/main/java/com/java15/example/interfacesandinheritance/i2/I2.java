package com.java15.example.interfacesandinheritance.i2;

import com.java15.example.classesobjects.Person;
import com.java15.example.interfacesandinheritance.DemoInterface;

import java.util.Comparator;

public interface I2  {

    String msg(String param1, String param2, String param3);

    static String msg(){
        return """
                I2
                """;
    }

    static <T extends Comparable> int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

}
