package com.java15.example.sealed;

public sealed interface SubTopInterface extends TopInterface permits SubSubTopInterface{
    default String show(){
        return "SubTopInterface";
    }
}
