package com.java15.example.sealed;

public class ConcreteClass implements SubSubTopInterface {
    @Override
    public <T> void consume(T t) {
        System.out.println("ConcreteClass::"+t);
    }
}
