package com.java15.example.generics;

import com.java15.example.classesobjects.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        //genericSingleTypeDemo();
        //genericKeyValueDemo();
        res();
        }

    public static void res(){
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        Pair<Integer, String> p3 = new Pair<>(1, "apple");
        boolean same1 = Util.compare(p1, p2);
        System.out.println(same1);
        boolean same2 = Util.compare(p1, p3);
        System.out.println(same2);
    }

    static public void genericSingleTypeDemo(){
        GenericSingleType<Person> persons = new GenericSingleType<>();
        persons.setType(new Person("sam1", LocalDate.now(), Person.Sex.MALE,"sam1@gmail.com",31));
        persons.setType(new Person("sam2", LocalDate.now(), Person.Sex.FEMALE,"sam2@gmail.com",33));
        persons.setType(new Person("sam3", LocalDate.now(), Person.Sex.MALE,"sam3@gmail.com",32));
        persons.sort(Comparator.comparing(Person::getAge));

    }

    static public void genericKeyValueDemo(){
        GenericKeyValueType<Integer,Person> persons = new GenericKeyValueType<>();
        persons.setType(10,new Person("sam1", LocalDate.now(), Person.Sex.MALE,"sam1@gmail.com",31));
        persons.setType(12,new Person("sam2", LocalDate.now(), Person.Sex.FEMALE,"sam2@gmail.com",33));
        persons.setType(11,new Person("sam3", LocalDate.now(), Person.Sex.MALE,"sam3@gmail.com",32));
        persons.sortKeyValue(Comparator.comparing(Map.Entry::getKey));
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) { this.key = key; }
        public void setValue(V value) { this.value = value; }
        public K getKey()   { return key; }
        public V getValue() { return value; }
    }
    static class Util {
        public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) &&
                    p1.getValue().equals(p2.getValue());
        }
    }
}
