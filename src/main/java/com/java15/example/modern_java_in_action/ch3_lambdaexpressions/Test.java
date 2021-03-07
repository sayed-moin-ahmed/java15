package com.java15.example.modern_java_in_action.ch3_lambdaexpressions;

import com.java15.example.modern_java_in_action.Apple;
import com.java15.example.modern_java_in_action.Colors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Test {

    public static  int staticValue = 10;
    public int instanceValue = 20;

    public static void main(String[] args) {
        //extracted1();
        //extracted2();
        //extracted3();
        //extracted4(startsWithNumber.test("1he"));

    }

    private static void extracted4(boolean test) {
        System.out.println(test);
    }

    static Predicate<String> startsWithNumber = (String string) -> Test.startsWithNumber(string);

    static private Boolean startsWithNumber(String value) {
        if(value.contains("1"))
            return true;
        return false;
    }

    private static void extracted3() {
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String::compareToIgnoreCase);
        str.forEach(System.out::println);
    }

    private static void extracted2() {
        String msg = "Hello World!!!";
        String strValue = "10";
        operate(msg,String::length);
        operate(strValue,String::toUpperCase);
        operate(strValue,String::toLowerCase);
        operate(strValue,String::toString);
        operate(strValue,String::format);
    }

    private static void extracted1() {
        int methodValue = 30;
        System.out.println(isEmpty.test(List.of()));
        System.out.println(supplier.get());
        consumer.accept(supplier.get());
        intConsumer.accept(staticValue);
        intConsumer.accept(methodValue);
        methodValue =  40;
        System.out.println(add.apply(10,20));
    }

    public static <T,R> void operate(T type,Function<T,R> function){
        System.out.println(function.apply(type));
    }

    public static <T,R> void operate(T type,UnaryOperator<T> unaryOperator){
        System.out.println(unaryOperator.apply(type));
    }

    static Predicate<List<String>> isEmpty = list -> list.isEmpty();
    static Supplier<Apple> supplier = () -> new Apple(10, Colors.RED);
    static Consumer<Apple> consumer = apple -> System.out.println(apple);
    static Consumer intConsumer = i -> System.out.println(i);
    static BiFunction<Integer,Integer,Integer> add = (a,b)->a+b;
    Comparator<Apple> byName = (Apple o1, Apple o2)->o1.getWeight().compareTo(o2.getWeight());
}
