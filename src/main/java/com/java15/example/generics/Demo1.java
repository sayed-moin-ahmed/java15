package com.java15.example.generics;

public sealed class Demo1 extends Demo2 implements  Interface2  permits Demo{
    public String show(){
        return "Demo1";
    }
}
