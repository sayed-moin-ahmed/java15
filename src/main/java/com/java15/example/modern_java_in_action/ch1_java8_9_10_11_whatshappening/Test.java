package com.java15.example.modern_java_in_action.ch1_java8_9_10_11_whatshappening;

import com.java15.example.modern_java_in_action.Apple;
import com.java15.example.modern_java_in_action.Data;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {

    public static void main(String[] args) {
        List<Apple>  apples = Data.getData();
        //filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
        // filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
        // filterGroupApples(apples,(Apple a) -> Colors.RED.equals(a.getColor())).forEach((i,list) ->{System.out.println(i+""+list);});
        // filterGroupApples(apples,(Apple a) -> {return true;}).forEach((i,list) ->{System.out.println(i+""+list);});
        // minAppleByWeight(apples).ifPresent(System.out::println);
        // maxAppleByWeight(apples).ifPresent(System.out::println);
        // getData1().forEach(System.out::println);
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

    static File[] handlingFiles(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

}


