package com.java15.example.interfacesandinheritance;

public interface Flyer {
    default public String identifyMyself(){
        return "I am able to fly.";
    }
}
