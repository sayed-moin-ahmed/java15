package com.java15.example.patternmatchinginstanceof;

public sealed interface Shape permits Circle,Rectangle {
    double area();
}
