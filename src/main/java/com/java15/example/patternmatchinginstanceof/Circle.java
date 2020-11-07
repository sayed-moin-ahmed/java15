package com.java15.example.patternmatchinginstanceof;

public record Circle(int radius) implements Shape {
    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }
}
