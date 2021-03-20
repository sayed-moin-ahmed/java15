package com.java15.example.modern_java_in_action.ch6_collectingdatawithstreams;

import com.java15.example.modern_java_in_action.Dish;
import com.java15.example.modern_java_in_action.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Test {
    public static void main(String[] args){
        List<Dish> dishes = List.of(
                new Dish(Type.CHINESE,"Veg Soup",100),
                new Dish(Type.CHINESE,"Chiken Soup",350),
                new Dish(Type.WESTERN,"Continental",250),
                new Dish(Type.INDIAN,"Butter Masala",500)
        );

        /*Map<Boolean,List<Dish>> partitionBy = dishes.stream().collect(Collectors.partitioningBy(dish->Type.CHINESE==dish.getType()));
        partitionBy.forEach((key, value) -> System.out.println(key + " " + value));

        Map<Type, List<Dish>> groupingBy = dishes.stream().collect(groupingBy(Dish::getType));
        groupingBy.forEach((k,v)->System.out.println(k+" "+v));*/


        Optional<Dish> max1 = dishes.stream().max(Comparator.comparing(Dish::getCalories));
        Optional<Integer> max2 = dishes.stream().map(Dish::getCalories).reduce(Integer::max);
        System.out.println(max1 +""+max2);

    }

}

