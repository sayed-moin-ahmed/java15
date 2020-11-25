package com.java15.example.classesobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

/**
 * https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html#implcit_and_synthetic
 */
public class OuterClass {

    private static int counter=0;
    private String name;
    private int age;
    List<String> list = new ArrayList<>();

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public void add(String value){
        list.add(value);
    }

    public Iterator iterator(){
        int val = list.size();

        Iterator iterator = new Iterator() {
            int counter=0;
            @Override
            public boolean hasNext() {
                return counter<val;
            }
            @Override
            public Object next() {
                return list.get(counter++);
            }
        };
        return iterator;
    }

    enum Colors{
        RED,GREEN;
    }

    static public class StaticPublicNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("StaticPublicNestedClass::"+counter/*+":age:"+age*/);//Non-static field 'age' cannot be referenced from a static context
            return "PublicNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public class PublicNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("PublicNestedClass::"+counter);
            return "PublicNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    protected class ProtectedNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("ProtectedNestedClass::"+counter);
            return "ProtectedNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    class PackagePrivateNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("PackagePrivateNestedClass::"+counter);
            return "PackagePrivateNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    private class PrivateNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PrivateNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public void showMethodInnerClass(int a, int b){

        final class MethodInnerClass{
            public Integer add(int a, int b){
                return a+b;
            }
        }

        record InnerRecord(Integer a, Integer b){
             private final static BiFunction<Integer,Integer,Integer> result = (p1, p2) -> p1+p2;
             public Integer add(){
                 return result.apply(a,b);
             }
        }
        System.out.println(new MethodInnerClass().add(a,b));
        System.out.println(new InnerRecord(a,b).add());
    }


    public static void showStaticMethodInnerClass(int a, int b){

        final class MethodInnerClass{
            public Integer add(int a, int b){
                return a+b;
            }
        }

        record InnerRecord(Integer a, Integer b){
            private final static BiFunction<Integer,Integer,Integer> result = (p1, p2) -> p1+p2;
            public Integer add(){
                return result.apply(a,b);
            }
        }

        System.out.println(new MethodInnerClass().add(a,b));
        System.out.println(new InnerRecord(a,b).add());
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}
