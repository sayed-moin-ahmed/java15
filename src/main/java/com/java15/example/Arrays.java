package com.java15.example;

/**
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 */
public class Arrays {
    public static void main(String[] args) {
        singleDimensionArray();
    }

    static public void singleDimensionArray(){
        /**
         *  This form is discouraged.
         *  However, convention discourages this form; the brackets identify the array type and should appear with the type designation.
         */
        float anArrayOfFloats[];
        /**
         * An array's type is written as type[], where type is the data type of the contained elements; the brackets are special symbols indicating that this variable holds an array.
         * The size of the array is not part of its type (which is why the brackets are empty).
         */
        int[] anArray = new int[5];
        for(int i=0;i<anArray.length;i++){
            System.out.println(anArray[i]);
        }

    }
}
