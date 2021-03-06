package com.java15.example.java8inaction.Java8_9_10_11_whatshappening;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {

    public static void main(String[] args) {
        List<Apple>  apples = getData();
       // beforeJava8(apples);
        //filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
        // filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
        // filterGroupApples(apples,(Apple a) -> Colors.RED.equals(a.getColor())).forEach((i,list) ->{System.out.println(i+""+list);});
        // filterGroupApples(apples,(Apple a) -> {return true;}).forEach((i,list) ->{System.out.println(i+""+list);});
        // minAppleByWeight(apples).ifPresent(System.out::println);
        // maxAppleByWeight(apples).ifPresent(System.out::println);
        // getData1().forEach(System.out::println);
    }

    private static void beforeJava8(List<Apple> apples) {
        final List<Apple> filteredApple = new ArrayList<>();
        apples.forEach(e->
        {
            if(new CustomPredicateImpl().test(e))
                filteredApple.add(e);
        });
        filteredApple.forEach(System.out::println);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream().filter(p).collect(Collectors.toList());
    }

    static Map<Integer, List<Apple>> filterGroupApples(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream().filter(p).collect(groupingBy(Apple::getWeight));
    }

    static Optional<Apple> minAppleByWeight(List<Apple> inventory) {
        return inventory.stream().min(Comparator.comparing(Apple::getWeight));
    }

    static Optional<Apple> maxAppleByWeight(List<Apple> inventory) {
        return inventory.stream().max(Comparator.comparing(Apple::getWeight));
    }

    private static List<Apple> getData() {
        Apple apple1 = new Apple(10,Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(3,Colors.RED);
        Apple apple6 = new Apple(5,Colors.GREEN);
        List<Apple> apples =  List.of(apple1,apple2,apple3,apple4,apple5,apple6);
        return apples;
    }

    private static List<Apple> getData1() {
        Apple apple1 = new Apple(10,Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(3,Colors.RED);
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

    static File[] handlingFiles(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

}

interface CustomPredicate<T>{
    boolean test(T t);
}

class CustomPredicateImpl implements CustomPredicate{

    @Override
    public boolean test(Object o) {
        if(Colors.GREEN.equals(((Apple)o).getColor()))
            return true;
        return false;
    }
}

