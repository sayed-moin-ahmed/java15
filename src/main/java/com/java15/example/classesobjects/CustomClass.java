package com.java15.example.classesobjects;

public class CustomClass extends CustomSealedSubClass {
    @Override
    public void show() {
        System.out.println("CustomClass");
        super.show();
    }
}
