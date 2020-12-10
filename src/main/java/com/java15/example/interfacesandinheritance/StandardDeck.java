package com.java15.example.interfacesandinheritance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StandardDeck {

    private List<Card> list = new ArrayList<>();

    StandardDeck(){
        list.add(new Card(10,3));
        list.add(new Card(5,5));
        list.add(new Card(2,10));
    }

    public void sort(Comparator<Card> comparator){
        list.sort(comparator);
        System.out.println(list);
    }

}
