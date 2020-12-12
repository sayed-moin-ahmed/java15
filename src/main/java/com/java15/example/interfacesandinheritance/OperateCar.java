package com.java15.example.interfacesandinheritance;

public interface OperateCar {
    default int startEngine(int key){
        return key;
    }
}
