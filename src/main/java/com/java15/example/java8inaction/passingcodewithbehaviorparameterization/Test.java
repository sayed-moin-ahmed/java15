package com.java15.example.java8inaction.passingcodewithbehaviorparameterization;

import com.java15.example.java8inaction.Apple;
import com.java15.example.java8inaction.Colors;
import com.java15.example.java8inaction.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {
    public static void main(String[] args) {
        List<Apple> apples = Data.getData();
        // beforeJava8(apples);
        //filter(apples,(Apple e) -> Colors.GREEN.equals(e.getColor())).forEach(System.out::println);
        groupBy(apples,apple -> apple.getWeight()).forEach((i, list)->System.out.println(i+""+list));
    }

    //More Generic
    static public<T> List<T> filter(List<T> list,Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    static public <T,K> Map<? extends K, List<T>> groupBy(List<T> list, Function<? super T, ? extends K> classifier){
        return  list.stream().collect(groupingBy(classifier));
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
