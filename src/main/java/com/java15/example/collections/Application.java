package com.java15.example.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 */
public class Application {

    public static void main(String[] args) {
        List<Integer> list = getData();
        //collectionInterfaceDemo();
        //aggregationExample();
        //extracted();
        iteratorDemo(list);
        forEachDemo(list);
        while (true) {
            Thread thread = new Thread(new RemoveDemo(list));
            thread.setName(thread.getName());
            thread.start();
            stringConsumer.accept(thread.getName());
        }
    }

    static class RemoveDemo implements Runnable{

        private final List<Integer> list;
        RemoveDemo(List<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {
            var iterator = list.iterator();
            while (iterator.hasNext()){
                var value = iterator.next();
                if(Objects.nonNull(value)) {
                    iterator.remove();
                    stringConsumer.accept("Removed..."+ Thread.currentThread().getName());
                }
            }
        }
    }

    private static List<Integer> getData() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        return list;
    }

    //can't remove element
    private static void forEachDemo(List list) {
        List.of(1,2,3,4).forEach(System.out::println);
        for(var v : list){
            System.out.println("Result::"+v);
        }
    }

    private static void iteratorDemo(List<Integer> list){
        list.removeIf(value -> 3 == value);
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
