package com.java15.example.modern_java_in_action.ch5_workingwithstream;

import com.java15.example.modern_java_in_action.Dish;
import com.java15.example.modern_java_in_action.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER));


        specialMenu.stream().filter(dish->dish.getCalories()<320).collect(toList()).forEach(System.out::println);
    }
}
