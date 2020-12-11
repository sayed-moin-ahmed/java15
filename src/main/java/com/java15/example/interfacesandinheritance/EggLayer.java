package com.java15.example.interfacesandinheritance;

public interface EggLayer extends Animal{
    default public String identifyMyself(){
        return "I am able to lay eggs";
    }
}
