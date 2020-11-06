package com.java15.example.sealed;


public non-sealed class FilledRectangle extends Rectangle {
    public double red,green,blue;

    public FilledRectangle(double red, double green, double blue, double length, double width) {
        super(length,width);
        this.red = red;
        this.green = green;
        this.blue = blue;
        System.out.println("FilledRectangle");
    }

    @Override
    public String toString() {
        return "FilledReactangle{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", length=" + length +
                ", width=" + width +
                ", side=" + side +
                '}';
    }
}
