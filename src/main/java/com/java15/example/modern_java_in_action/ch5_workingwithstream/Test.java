package com.java15.example.modern_java_in_action.ch5_workingwithstream;

import com.java15.example.modern_java_in_action.Dish;
import com.java15.example.modern_java_in_action.Trader;
import com.java15.example.modern_java_in_action.Transaction;
import com.java15.example.modern_java_in_action.Type;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("french fries", true, 30, Type.OTHER),
                new Dish("french fries", true, 530, Type.OTHER)
        );


        /*specialMenu.stream().filter(dish->dish.getCalories()<320).collect(toList()).forEach(System.out::println);
        specialMenu.stream().dropWhile(dish->dish.getCalories()<320).collect(toList()).forEach(System.out::println);
        specialMenu.stream().takeWhile(dish->dish.getCalories()<320).collect(toList()).forEach(System.out::println);
        specialMenu.stream().filter(dish -> dish.getType() == Type.MEAT).limit(2).collect(toList());*/

       /* String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        streamOfwords.map(word -> word.split("")).flatMap(Arrays::stream).forEach( System.out::println);*/

       /* List<Integer> numbers = Arrays.asList(1, 2, 3);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());*/



        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //transactions.stream().filter(transaction ->2011 == transaction.getYear()).sorted(Comparator.comparing(Transaction::getValue)).collect(toList()).forEach(System.out::println);
        //transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList()).forEach(System.out::println);
       /* transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);*/

        /*String value = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("",(n1,n2)->n1+n2);
        System.out.println(value);*/

       /* Optional<Integer> maxTransactions = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(maxTransactions.get());*/

      /* OptionalInt sumValue =  transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
       System.out.println(sumValue.orElse(0));

       int sum = transactions.stream()
               .mapToInt(Transaction::getValue)
               .sum();
       System.out.println(sum);*/

       /* System.out.println( transactions.stream().mapToInt(Transaction::getValue).average());
        System.out.println( transactions.stream().mapToInt(Transaction::getValue).min());
        System.out.println( transactions.stream().mapToInt(Transaction::getValue).max());
        System.out.println( transactions.stream().mapToInt(Transaction::getValue).count());*/

        UnaryOperator<String> lowerCase =  String::toLowerCase;
        Stream.generate(()->"Hello World!").limit(5).forEach(System.out::println);
        Stream.iterate("Hello World!",lowerCase).limit(4).forEach(System.out::println);
    }
}
