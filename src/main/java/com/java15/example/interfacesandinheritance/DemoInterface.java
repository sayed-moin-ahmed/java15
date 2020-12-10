package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I12;
import com.java15.example.interfacesandinheritance.i2.I22;

/**
 * https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 */
public interface DemoInterface extends I12, I22 {
    default  String msg(){
        System.out.println(I12.super.msg());
        System.out.println(I22.super.msg());
        return "DemoInterface";
    }
}
