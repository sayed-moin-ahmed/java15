package com.java15.example.sealed;



public sealed class Rectangle extends Shape permits FilledRectangle {
    public double length,width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        System.out.println("Rectangle");
    }
}
