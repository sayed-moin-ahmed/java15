package com.java15.example.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final public class ImmutableClass {

    private String name;
    private int age;
    private List<String> addresses;

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private ImmutableClass(){}

    final public static ImmutableClass getInstance(final String name, final int age, final List<String> addresses){
        ImmutableClass instance = new ImmutableClass();
        instance.name = name;
        instance.age = age;
        instance.addresses = Collections.unmodifiableList(new ArrayList<>(addresses));
        return instance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}

