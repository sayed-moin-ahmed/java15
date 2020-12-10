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


    public String msg(String msg) {
        return String.format("Hello %s", msg);
    }

    public String msg(String param1, String param2) {
        return String.format("%s %s",param1,param2);
    }

    public String msg(String param1, String param2, String param3) {
        return String.format(param1,param2,param3);
    }
}
