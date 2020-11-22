package com.java15.example.classesobjects;

public class CustomClass extends CustomSealedSubClass {

    public CustomClass(){
        this("Hello CustomClass");
    }

    public CustomClass(String msg){
        super(msg);
    }

    @Override
    public void show() {
        System.out.println("CustomClass");
        super.show();
    }
}
