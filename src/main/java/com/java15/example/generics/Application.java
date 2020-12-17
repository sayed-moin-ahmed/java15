package com.java15.example.generics;

import com.java15.example.classesobjects.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 */
public class Application {
    public static void main(String[] args) {
        //genericSingleTypeDemo();
        //genericKeyValueDemo();
        //res();
        //multipleBounds();
        subTyping(List.of(new Demo(), new Demo()));
        //subTyping(List.of(new Demo1(),new Demo1()));//Incompatible bounds
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

    public <T extends Interface2 & Interface1> void show1(T type){
        System.out.println(type.show());
    }


    public <T extends Demo1 , Interface2 , Interface1> void show2(T type){
        System.out.println(type.show());
    }

    //
    public <T extends Demo2 , Interface2 , Interface1> void show3(T type){
        System.out.println(type.show());
    }

    public <T extends Demo & Interface2 & Interface1> void show4(T type){
        System.out.println(type.show());
    }

    //
    public <Demo2 extends Interface2 & Interface1> void show5(Demo2 type){
        System.out.println(type.show());
    }

    public <T extends RecordDemo & Interface2 & Interface1> void show6(T type){
        System.out.println(type.show());
    }

    public static void multipleBounds(){
        Demo demo = new Demo();
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo();
        Demo2 demo2_1 = new Demo2();
        Interface1 interface1 = new Demo1();
        Interface2 interface2 = new Demo();
        RecordDemo interfaceR = new RecordDemo();
        new Application().show1(demo);
        new Application().show1(demo1);
        new Application().show3(demo2);
        new Application().show4(demo);
        new Application().show6(interfaceR);
        System.out.println(interface1.show());
        System.out.println(interface2.show());
    }

    public static void subTyping(List<Demo> list){
        for(Demo demo : list){
            System.out.println(demo);
        }
    }

    static public void extendedSubTyping() {
        PayloadList<String, String> payloadListStringString;
        PayloadList<String, Integer> payloadListStringInteger;
        PayloadList<String, Exception> payloadListStringException;
    }

}
