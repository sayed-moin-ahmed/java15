package com.java15.example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        //collectionInterfaceDemo();

        aggregationExample();
    }

    private static void aggregationExample() {
        List.of(1,2,3,4,5,6,7,8,9,0).stream().map(Object::toString).forEach(System.out::println);
        intConsumer.accept(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).stream().mapToInt(e -> e).sum());
        intConsumer.accept(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).stream().collect(Collectors.summingInt(e->e)));
        stringConsumer.accept(List.of(1,2,3,4,5,6,7,8,9,0).stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    static Consumer<String> stringConsumer = System.out::println;
    static Consumer<Integer> intConsumer = System.out::println;

    private static void collectionInterfaceDemo() {
        Predicate<String> predicate = str -> str.equals("Hello ");
        Collection<String> collection = new ArrayList<>();
        collection.add("Hello ");
        collection.add("world.");
        collection.stream().forEach(System.out::println);
        collection.stream().map(String::length).forEach(System.out::println);
        Function<String,String> mapper = String::stripIndent;
        System.out.println(collection.stream()/*.filter(predicate)*/.map(mapper).collect(Collectors.joining()));
    }

}
