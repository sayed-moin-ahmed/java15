package com.java15.example.interfacesandinheritance;

public class DemoInterfaceImplV1 implements DemoInterface {

    @Override
    public String msg(String msg) {
        return String.format("Hello %s", msg);
    }
}
