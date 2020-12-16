package com.java15.example.generics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericKeyValueType<K,V> {
    private K key;
    private V value;
    Map<K,V> map = new HashMap<>();

    public Map<K,V> getMap() {
        return map;
    }

    public void setType(K key, V value){
        map.put(key, value);
    }

    @Override
    public String toString() {
        return "GenericKeyValueType{" +
                "key=" + key +
                ", value=" + value +
                ", map=" + map +
                '}';
    }

    public void clear(){
        map.clear();
    }

    public void sortKeyValue(Comparator<Map.Entry<K,V>> sort){
        var result = map
                .entrySet()
                .stream()
                .sorted(sort)
                .collect(Collectors.toMap(Function.identity(),v->v))
        ;
        result.forEach((k,v)->System.out.println("Key:"+k+":Value:"+v));
    }
}
