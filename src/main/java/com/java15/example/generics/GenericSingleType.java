package com.java15.example.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericSingleType<T> {

    List<T> list = new ArrayList<>();

    public GenericSingleType() {
    }

    public List<T> getType() {
        return list;
    }

    public void setType(T type){
        list.add(type);
    }

    @Override
    public String toString() {
        return "GenericSingleType{" +
                "list=" + list +
                '}';
    }

    public void clear(){
        list.clear();
    }

    public void sort(Comparator<T> sort){
        list
                .stream()
                .sorted(sort)
                .forEach(System.out::println);
    }
}
