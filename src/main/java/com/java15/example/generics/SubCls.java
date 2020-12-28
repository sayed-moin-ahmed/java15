package com.java15.example.generics;

//Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
public class SubCls extends SuperCls{

    //
   /* public <T> void show(Object type){
        System.out.println("Sub<T>:"+type);
    }*/

    public <T extends Number> void show(T type){
       System.out.println("<T extends Number>:"+type);
    }

    public <T extends Number>  T getType(T type){
        return  type;
    }

}
