package com.java15.example.lru;

public class LRUCacheTest {

    public static void main(String[] args){
        LRUCache<Integer, Integer> c = new LRUCache<>(2);
        System.out.println(c.get(1));
        c.put(1, 1);
        System.out.println(c);
    }

}
