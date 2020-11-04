package com.java15.example.sealed;

public non-sealed interface SubSubTopInterface extends SubTopInterface{
    default String show(){
        return "SubSubTopInferface";
    }
    <T> void consume(T t);
}
