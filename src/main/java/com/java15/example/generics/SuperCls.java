package com.java15.example.generics;

//Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
public class SuperCls {

   //'show(T)' clashes with 'show(Object)'; both methods have same erasure
    public <T> void show(T type){
        System.out.println("Super<T>:"+type);
    }

    /**
     *'show(T)' in 'com.java15.example.generics.SubCls' clashes with 'show(Object)' in 'com.java15.example.generics.SuperCls';
     * both methods have same erasure, yet neither overrides the other
     */
   /* public Object show(Object type){
        System.out.println("Super<T extends Number>:"+type);
    }*/

    public <T extends Number>  T getType(T type){
        return  type;
    }

}
