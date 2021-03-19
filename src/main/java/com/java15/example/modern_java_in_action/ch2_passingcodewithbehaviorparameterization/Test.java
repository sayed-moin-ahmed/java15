package com.java15.example.modern_java_in_action.ch2_passingcodewithbehaviorparameterization;

import com.java15.example.modern_java_in_action.Apple;
import com.java15.example.modern_java_in_action.Colors;
import com.java15.example.modern_java_in_action.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Apple> apples = Data.getApples();
        // beforeJava8(apples);
        //filter(apples,(Apple e) -> Colors.GREEN.equals(e.getColor())).forEach(System.out::println);
        // groupBy(apples,apple -> apple.getWeight()).forEach((i, list)->System.out.println(i+""+list));
        executorService(()->{ int i=0; while(i<10){ i++;} return i;});
    }


    private static <V> void executorService(Callable<V> task) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<V> threadName = executorService.submit(task);
        System.out.println(threadName.get());
        executorService.shutdown();
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
