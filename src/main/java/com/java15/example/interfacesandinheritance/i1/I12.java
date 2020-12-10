package com.java15.example.interfacesandinheritance.i1;

public interface I12 {
    default String msg(){
        return "I12";
    }

    static void msg(String value){
        System.out.println(value);
    }
}
