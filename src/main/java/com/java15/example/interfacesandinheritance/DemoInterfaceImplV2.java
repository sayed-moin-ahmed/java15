package com.java15.example.interfacesandinheritance;

public class DemoInterfaceImplV2 implements  DemoInterface{
    @Override
    public String msg(String msg) {
        return msg;
    }

    @Override
    public String msg(String param1, String param2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String msg(String param1, String param2, String param3) {
        throw new UnsupportedOperationException();
    }
}
