package com.java15.example.modern_java_in_action;

public class Dish {

    private Type type;
    private String name;
    private int calories;

    public Dish(){}

    public Dish(Type type, String name, int calories) {
        this.type = type;
        this.name = name;
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
