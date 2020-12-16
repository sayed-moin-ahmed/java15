package com.java15.example.generics;

import com.java15.example.classesobjects.Person;

import java.time.LocalDate;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        genericSingleTypeDemo();
    }

    static public void genericSingleTypeDemo(){
        GenericSingleType<Person> persons = new GenericSingleType<>();
        persons.setType(new Person("sam1", LocalDate.now(), Person.Sex.MALE,"sam1@gmail.com",31));
        persons.setType(new Person("sam2", LocalDate.now(), Person.Sex.FEMALE,"sam2@gmail.com",33));
        persons.setType(new Person("sam3", LocalDate.now(), Person.Sex.MALE,"sam3@gmail.com",32));
        persons.sort(Comparator.comparing(Person::getAge));

    }
}
