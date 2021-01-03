package com.java15.example.collections;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable, Comparator{


    final private String name;
    final private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o,"Person object required!");
        if(o instanceof Person person) {
            if (person.getAge() == this.getAge() && 0 == person.getName().compareTo(name))
                return 0;
            else if (person.getAge() > this.getAge() && 1 == person.getName().compareTo(name)) {
                return 1;
            } else
                return -1;
        }else
            throw new IllegalArgumentException("Not an instance of Person.");
    }

    @Override
    public int compare(Object o1, Object o2) {
        Objects.requireNonNull(o1,"Person object required!");
        Objects.requireNonNull(o2,"Person object required!");
        if(o1 instanceof Person person1 && o2 instanceof  Person person2) {
            if (person1.getAge() == person2.getAge() && 0 == person1.getName().compareTo(person2.getName()))
                return 0;
            else if (person1.getAge() > person2.getAge() && 1 == person1.getName().compareTo(person2.getName())) {
                return 1;
            } else
                return -1;
        }else
            throw new IllegalArgumentException("Not an instance of Person.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name.length()+age;
    }
}

