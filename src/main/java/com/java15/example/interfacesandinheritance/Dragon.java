package com.java15.example.interfacesandinheritance;

public class Dragon implements EggLayer,FireBreather{

    public static void main(String[] args) {
        Dragon myapp = new Dragon();
        System.out.println(myapp.identifyMyself());
    }

}
