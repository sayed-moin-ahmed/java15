package com.java15.example.modern_java_in_action.ch3_lambdaexpressions;

import com.java15.example.modern_java_in_action.Apple;
import com.java15.example.modern_java_in_action.Colors;
import com.java15.example.modern_java_in_action.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static java.util.Comparator.comparing;

public class Test {

    public static  int staticValue = 10;
    public int instanceValue = 20;

    public static void main(String[] args) {
        //extracted1();
        //extracted2();
        //extracted3();
        //extracted4(startsWithNumber.test("1he"));
        //extracted5();
        //extracted6();
        //extracted7();
        //extracted8();
        extracted9();
    }

    private static void extracted9() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        int result = h.apply(1);
        System.out.println(result);
    }

    private static void extracted8() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);
    }

    private static void extracted7() {
        Data.getData().stream().filter(notRedApple).forEach(System.out::println);
        Data.getData().stream().filter(redAppleWithConditions).forEach(System.out::println);
    }

    static Predicate<Apple> redApple = apple -> Colors.RED.equals(apple.getColor());
    static Predicate<Apple> notRedApple = redApple.negate();
    static Predicate<Apple> redAppleWithConditions = redApple.and(apple -> apple.getWeight()>2).or(apple ->Colors.GREEN.equals(apple.getColor()));


    private static void extracted6() {
        List<Apple> list = Data.getData1();
        list.sort(comparing(Apple::getWeight).reversed());
        list.forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++");
        list.sort(comparing(Apple::getColor).thenComparing(Apple::getWeight));
        list.forEach(System.out::println);
    }

    private static void extracted5() {
        Supplier<Apple> appleSupplier = Apple::new;
        System.out.println(appleSupplier.get());
        Function<Integer,Apple> appleFunction = Apple::new;
        System.out.println(appleFunction.apply(10));
        BiFunction<Integer,String,Apple> appleBiFunction = Apple::new;
        System.out.println(appleBiFunction.apply(10,Colors.RED));
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        map(weights, Apple::new).forEach(System.out::println);
    }
    static public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer i: list) {
            result.add(f.apply(i));
        }
        return result;
    }

    private static void extracted4(boolean test) {
        System.out.println(test);
    }

    static Predicate<String> startsWithNumber = (String string) -> Test.startsWithNumber(string);

    static private Boolean startsWithNumber(String value) {
        return value.contains("1");
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
