package com.java15.example.modern_java_in_action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Data {
    public static List<Apple> getData() {
        Apple apple1 = new Apple(10, Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(3,Colors.RED);
        Apple apple6 = new Apple(5,Colors.GREEN);
        List<Apple> apples =  List.of(apple1,apple2,apple3,apple4,apple5,apple6);
        return apples;
    }

    public static List<Apple> getData1() {
        Apple apple1 = new Apple(10,Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(7,Colors.RED);
        Apple apple6 = new Apple(5,Colors.GREEN);
        List<Apple> apples =  new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        apples.add(apple6);
        apples.sort(Comparator.comparing(Apple::getWeight));
        return apples;
    }
}
