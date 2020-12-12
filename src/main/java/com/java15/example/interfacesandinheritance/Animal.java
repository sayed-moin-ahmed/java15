package com.java15.example.interfacesandinheritance;

public interface Animal {
    default public String identifyMyself(){
        return "I am an animal";
    }
}
