package com.java15.example.java8inaction.passingcodewithbehaviorparameterization;

import com.java15.example.java8inaction.Apple;
import com.java15.example.java8inaction.Colors;
import com.java15.example.java8inaction.Data;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Apple> apples = Data.getData();
        beforeJava8(apples);
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
