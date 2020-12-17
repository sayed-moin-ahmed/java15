package com.java15.example.generics;

public record RecordDemo() implements Interface1,Interface2 {
    @Override
    public String show() {
        return "recorddemo";
    }
}
