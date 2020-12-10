package com.java15.example.interfacesandinheritance;

public class Card {
    private int value;
    private int suits;

    public int getValue() {
        return value;
    }

    public int getSuits() {
        return suits;
    }

    public Card(int value, int suits) {
        this.value = value;
        this.suits = suits;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suits=" + suits +
                '}';
    }
}
