package com.java15.example.classesobjects;

public sealed class CustomSealedClass implements  SubInterface permits CustomSealedSubClass  {
    public CustomSealedClass(String msg) {
        System.out.println("CustomSealedClass::"+msg);
    }

    @Override
    public void show() {
        System.out.println("CustomSealedClass");
    }
}
