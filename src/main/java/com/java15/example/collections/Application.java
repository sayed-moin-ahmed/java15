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

        //aggregationExample();

        extracted();

    }

    /**
     * The Collections framework has always provided a number of so-called "bulk operations" as part of its API.
     * These include methods that operate on entire collections, such as containsAll, addAll, removeAll, etc.
     * Do not confuse those methods with the aggregate operations that were introduced in JDK 8.
     * The key difference between the new aggregate operations and the existing bulk operations (containsAll, addAll, etc.) is that the old versions are all mutative, meaning that they all modify the underlying collection.
     * In contrast, the new aggregate operations do not modify the underlying collection.
     * When using the new aggregate operations and lambda expressions, you must take care to avoid mutation so as not to introduce problems in the future, should your code be run later from a parallel stream.
     */
    private static void extracted() {
        int counter = 0;
        List<Integer> list =  new ArrayList<>();
        while (counter<10){
            list.add(counter++);
            new Thread(new Demo(list)).start();
        }
    }

    static final class Demo implements Runnable{

        private final Collection<?> collection;

        private Demo(Collection<?> collection){
            this.collection = collection;
        }

        @Override
        public void run() {
            collection.stream().forEach(System.out::println);
        }
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
