package com.java15.example.interfacesandinheritance;

public interface FireBreather extends Animal{
    default public String identifyMyself(){
        return "I am able to lay eggs";
    }
}
