package com.java15.example.generics;

import com.java15.example.classesobjects.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        //genericSingleTypeDemo();
        genericKeyValueDemo();
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
}
