package com.java15.example.classesobjects;

public class FunctionalInterfaceImpl implements TopInterface,TopInterface.NestedInterface{
    @Override
    public void show() {
        System.out.print("FunctionalInterfaceImpl");
    }

    public TopInterface.NestedInterface ni = new TopInterface.NestedInterface(){

        @Override
        public void show1() {
            System.out.println("Annymous NestedInterface");
        }
    };

    @Override
    public String toString() {
        return "FunctionalInterfaceImpl{}";
    }

    @Override
    public void show1() {
        System.out.println("NestedInterface");
    }
}
