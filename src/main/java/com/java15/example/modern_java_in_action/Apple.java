package com.java15.example.modern_java_in_action;

public class Apple {

    private Integer weight;
    private String color;

    public Apple(int weight){
        this.weight = weight;
    }

    public Apple(int weight,String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {}

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
