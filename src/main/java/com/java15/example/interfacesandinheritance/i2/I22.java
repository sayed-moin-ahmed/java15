package com.java15.example.interfacesandinheritance.i2;

public interface I22 {
    default String msg(){
        return "I22";
    }

    static void msg(String value){
        System.out.println(value);
    }
}
