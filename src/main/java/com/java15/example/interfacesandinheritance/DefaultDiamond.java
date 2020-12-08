package com.java15.example.interfacesandinheritance;

import com.java15.example.interfacesandinheritance.i1.I12;
import com.java15.example.interfacesandinheritance.i2.I22;

public interface DefaultDiamond extends I12, I22 {
    @Override
    default String msg() {
        return "DefaultDiamond";
    }
}
