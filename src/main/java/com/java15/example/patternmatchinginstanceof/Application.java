package com.java15.example.patternmatchinginstanceof;

/**
 * https://docs.oracle.com/en/java/javase/15/language/pattern-matching-instanceof-operator.html
 */
public class Application {
    public static void main(String[] args) {
        Shape shape = new Rectangle(6,10);
        if(shape  instanceof Circle s){
           System.out.println(s);
        }else if(shape instanceof Rectangle r && r.length()>5){ // if r.length() is less than 5 , then execution will go to else part
            System.out.println(r.area());
        }else{
            throw new IllegalArgumentException();
        }

        Shape s = new Circle(10);
        if (!(s instanceof Rectangle r)) {
            // You cannot use the binding variable r here.
        }
        // You can use r here. - Not working...
       //  System.out.println(r.length() > 5);
    }
}
