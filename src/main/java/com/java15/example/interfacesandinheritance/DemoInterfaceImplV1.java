package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I1;
import com.java15.example.interfacesandinheritance.i2.I2;

import java.text.DecimalFormat;

public class DemoInterfaceImplV1 implements DemoInterface {

    @Override
    public String msg(){
        DemoInterface.super.msg();
        return "Hello DemoInterfaceImplV1";
    }

    static public String msg(String msg) {
        return String.format("Hello %s", msg);
    }
}
