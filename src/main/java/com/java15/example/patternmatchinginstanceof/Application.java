package com.java15.example.patternmatchinginstanceof;

public class Application {
    public static void main(String[] args) {
        Shape shape = new Rectangle(10,10);
        if(shape  instanceof Circle s){
           System.out.println(s);
        }else if(shape instanceof Rectangle r){
            System.out.println(r.area());
        }else{
            throw new IllegalArgumentException();
        }
    }
}
