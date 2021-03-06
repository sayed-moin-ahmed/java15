package com.java15.example.java8inaction.Java8_9_10_11_whatshappening;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {

    public static void main(String[] args) {
        List<Apple>  apples = getData();
      //  filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
       // filterApples(apples,(Apple a) -> Colors.GREEN.equals(a.getColor())).stream().forEach(System.out::println);
         filterGroupApples(apples,(Apple a) -> Colors.RED.equals(a.getColor())).forEach((i,list) ->{System.out.println(i+""+list);});

    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream().filter(p).collect(Collectors.toList());
    }

    static Map<Integer, List<Apple>> filterGroupApples(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream().filter(p).collect(groupingBy(Apple::getWeight));
    }

    private static List<Apple> getData() {
        Apple apple1 = new Apple(10,Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(3,Colors.RED);
        Apple apple6 = new Apple(4,Colors.GREEN);
        List<Apple> apples =  List.of(apple1,apple2,apple3,apple4,apple5,apple6);
        return apples;
    }

    static File[] handlingFiles(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

}
