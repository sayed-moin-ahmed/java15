package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I1;
import com.java15.example.interfacesandinheritance.i2.I2;

public interface DemoInterface extends I1,I2 {
    String msg(String msg);
}
