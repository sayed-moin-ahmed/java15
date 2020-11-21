package com.java15.example.classesobjects;

public sealed class CustomSealedClass implements  SubInterface permits CustomSealedSubClass  {
    @Override
    public void show() {
        System.out.println("CustomSealedClass");
    }
}
