package com.java15.example.generics;

import com.java15.example.classesobjects.Person;

import java.io.ObjectStreamException;
import java.time.LocalDate;
import java.util.*;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 * https://stackoverflow.com/questions/6008241/what-is-the-difference-between-e-t-and-for-java-generics
 */
public class Application {
    public static void main(String[] args) {
        //genericSingleTypeDemo();
        //genericKeyValueDemo();
        //res();
        //multipleBounds();
        // subTyping(List.of(new Demo(), new Demo()));
        //subTyping(List.of(new Demo1(),new Demo1()));//Incompatible bounds
        //unboundedWildcardDemo();
        // objectStream(strings);//List<String> -> List<Obect>(invalid)
        //upperboundedWildcard(List.of(1,2,3));
        //upperboundedWildcard(List.of(1.1,2.2,3.3));
        //upperboundedWildcard(List.of("Hello","Hi")); //List<String -> List<? extends Number> incompatible
        //lowerBoundedWildcard(new ArrayList<>());
        //hierarchy();
        //subtyping();
    }

    private static void hierarchy() {
        SuperCls superCls = new SubCls();
        superCls.getType(11);
        superCls.show("Hello");
        superCls.show(11);
    }

    private static void subtyping() {
        List<?> list  = new ArrayList<>();
        List<? extends Number> integers1 = List.of(1,2);
        List<? extends Integer> integers2 = List.of(1,2);
        List<Integer> integers3 = List.of(1);
        List<? super Integer> integer4 = List.of(2,3);
        List<? super Number> integer5 = List.of(5,6);
        List<Number> integer6 =  List.of(89);
        integer5 = integer6;
        integer4 = integer5;
        list = integer4;
        integers2 = integers3;
        integers1=integers2;
        list = integers1;
    }

    private static void unboundedWildcardDemo() {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("Dear");
        unboundedWildcard(strings);
        List<Integer> li = Arrays.asList(1, 2, 3);
        unboundedWildcard(li);
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

    public static void lowerBoundedWildcard(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.<Number>add(i);
        }
        System.out.println(list);
    }

    static public void unboundedWildcard(List<?> list){
        System.out.println("unboundedWildcard::"+list);
        list.stream().forEach(System.out::println);
    }

    static public void upperboundedWildcard(List<? extends Number> list){
        System.out.println("upperboundedWildcard::"+list);
        list.stream().forEach(System.out::println);
    }

    /**
     * Below Example give error like "Wrong number of type arguments: 2; required: 1"
     * @param list
     */
    /*static public void upperboundedWildcard1(List<? extends Number ,String> list){
        System.out.println("upperboundedWildcard::"+list);
        list.stream().forEach(System.out::println);
    }*/

    public static <T> void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }


    static public void objectStream(List<Object> list){
        System.out.println("ObjectStream::"+list);
        list.stream().forEach(System.out::println);
    }

    /**
     * Difference between T & ?
     */

    public <T> void foo1(List<T> listOfAnyType) { // T can be used for class and methods

    }
    public void foo2(List<?> listOfAnyType) { // <?> used only for parameters and variable declartions
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>

        //below are incompatible
        /*List<Demo1> lb = new ArrayList<>();
        List<Demo> la = lb;*/
    }  // pass a List of any type

    /*public <?> void foo3(? someType) {//unexpected wildcard

    } */ // error. Must use type params here

    void foo(List<?> i) {
       // i.set(0, i.get(0));
        fooHelper(i);
    }

    //https://docs.oracle.com/javase/tutorial/java/generics/capture.html
    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}
