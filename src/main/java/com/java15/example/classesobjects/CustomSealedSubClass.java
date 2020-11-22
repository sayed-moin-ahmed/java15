package com.java15.example.classesobjects;

public non-sealed class CustomSealedSubClass extends CustomSealedClass{
    static{
        System.out.println("CustomSealedSubClass static Initializer 1");
    }
    {
        System.out.println("CustomSealedSubClass Initializer 1");
    }

    public CustomSealedSubClass(String msg){
        super(msg);
        System.out.println("Constructor CustomSealedSubClass::"+msg);
    }

    static{
        System.out.println("CustomSealedSubClass static Initializer 2");
    }
    {
        System.out.println("CustomSealedSubClass Initializer 2");
    }
    @Override
    public void show() {
        System.out.println("CustomSealedSubClass");
        super.show();
    }
}
