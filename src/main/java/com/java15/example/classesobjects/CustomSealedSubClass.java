package com.java15.example.classesobjects;

public non-sealed class CustomSealedSubClass extends CustomSealedClass{
    static{
        System.out.println("static Initializer 1");
    }
    {
        System.out.println("Initializer 1");
    }
    public CustomSealedSubClass(){
        System.out.println("Constructor CustomSealedSubClass");
    }
    static{
        System.out.println("static Initializer 2");
    }
    {
        System.out.println("Initializer 2");
    }
    @Override
    public void show() {
        System.out.println("CustomSealedSubClass");
        super.show();
    }
}
