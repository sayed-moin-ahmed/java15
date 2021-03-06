package com.java15.example.modern_java_in_action.ch3_lambdaexpressions;

import com.java15.example.modern_java_in_action.Apple;
import com.java15.example.modern_java_in_action.Colors;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {
        System.out.println(isEmpty.test(List.of()));
        System.out.println(supplier.get());
        consumer.accept(supplier.get());
        System.out.println(add.apply(10,20));
    }

    static Predicate<List<String>> isEmpty = list -> list.isEmpty();
    static Supplier<Apple> supplier = () -> new Apple(10, Colors.RED);
    static Consumer<Apple> consumer = apple -> System.out.println(apple);
    static BiFunction<Integer,Integer,Integer> add = (a,b)->a+b;
    Comparator<Apple> byName = (Apple o1, Apple o2)->o1.getWeight().compareTo(o2.getWeight());

}
