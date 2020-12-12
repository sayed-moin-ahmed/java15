package com.java15.example.interfacesandinheritance;

public class FlyingCar implements OperateCar,FlyCar{
    public static void main(String[] args) {
        System.out.println(new FlyingCar().startEngine(-1));
    }

    @Override
    public int startEngine(int key) {
        var result1 = FlyCar.super.startEngine(1);
        System.out.println(result1);
        var result2 = OperateCar.super.startEngine(1);
        System.out.println(result2);
        return key;
    }
}
