package com.java15.example.modern_java_in_action.ch4_introducingstreams;

import com.java15.example.modern_java_in_action.Data;
import com.java15.example.modern_java_in_action.Dish;
import com.java15.example.modern_java_in_action.Type;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Test {
    public static void main(String[] args) {
        List<Dish> dishes = Data.getDishes();
       /* List<String> dishNames1 = dishes.stream()
                .filter(dish -> dish.getCalories()>250)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(Collectors.toList());
        dishNames1.forEach(System.out::println);

        List<String> dishNames2 = dishes.parallelStream()
                .filter(dish -> dish.getCalories()>50)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(Collectors.toList());
        dishNames2.forEach(System.out::println);*/

        Map<Type,List<Dish>> map = dishes.stream().collect(groupingBy(Dish::getType));
        map.forEach((s,list)->System.out.println(s+""+list));
    }
}
