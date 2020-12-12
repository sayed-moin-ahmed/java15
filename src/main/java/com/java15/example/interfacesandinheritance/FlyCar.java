package com.java15.example.interfacesandinheritance;

public interface FlyCar {
    default int startEngine(int key) {
        return key;
    }
}