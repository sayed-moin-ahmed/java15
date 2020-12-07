package com.java15.example.classesobjects;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/examples/RosterTest.java
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
public class LambdaExpressions {


    private  static Check<Person> personGt7 =  p -> p.getAge() > 7;
    private static Consumer<Person> log = System.out::println;
    private static Predicate<Person> personLessThan = p -> p.getAge()<10;

    public static void main(String[] args){
        //printPersonsOlderThan(getPersons(),5);
        /*
        printPersonsOlderThan(getPersons(), new Check<Person>() {
            @Override
            public boolean test(Person type) {
                return type.getAge()>7;
            }

        });
        */

        printPersonsOlderThan(getPersons(),personGt7);
        printPersonLesserThan(getPersons(),personLessThan,log);
    }

    public static List<Person> getPersons(){
        return List.of(
                new Person("Test1", LocalDate.now(), Person.Sex.FEMALE,"test1@gmail.com",10),
                new Person("Test2", LocalDate.now(), Person.Sex.MALE,"test2@gmail.com",11),
                new Person("Test3", LocalDate.now(), Person.Sex.FEMALE,"test3@gmail.com",5),
                new Person("Test4", LocalDate.now(), Person.Sex.MALE,"test4@gmail.com",8),
                new Person("Test5", LocalDate.now(), Person.Sex.FEMALE,"test5@gmail.com",15),
                new Person("Test6", LocalDate.now(), Person.Sex.MALE,"test6@gmail.com",6),
                new Person("Test7", LocalDate.now(), Person.Sex.FEMALE,"test7@gmail.com",4),
                new Person("Test8", LocalDate.now(), Person.Sex.MALE,"test8@gmail.com",2),
                new Person("Test9", LocalDate.now(), Person.Sex.FEMALE,"test9@gmail.com",1),
                new Person("Test0", LocalDate.now(), Person.Sex.MALE,"test0@gmail.com",5)

        );
    }

    public static void printPersonsOlderThan(List<Person> roster, int age){
        for(Person person : roster){
            if(person.getAge()<10){
                System.out.println(person);
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, Check check){
        for(Person person : roster){
            if(check.test(person)){
                System.out.println(person);
            }
        }
    }

    public static void printPersonLesserThan(List<Person> roster, Predicate<Person> predicate, Consumer<Person> consumer){
        roster
                .stream()
                .filter(predicate)
                .forEach(consumer);
    }

}
