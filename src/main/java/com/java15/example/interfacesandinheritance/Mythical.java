package com.java15.example.interfacesandinheritance;

public interface Mythical {
    default public String identifyMyself(){
        return "I am a mythical creature.";
    }
}
