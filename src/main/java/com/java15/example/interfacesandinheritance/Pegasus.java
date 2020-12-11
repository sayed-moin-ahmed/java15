package com.java15.example.interfacesandinheritance;

public class Pegasus extends Horse implements  Flyer,Mythical{
    public static void main(String[] args){
        Pegasus pegasus = new Pegasus();
        System.out.println(pegasus.identifyMyself());
    }
}
