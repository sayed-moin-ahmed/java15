package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * https://www.programiz.com/java-programming/multidimensional-array
 */
public class Arrays {
    public static void main(String[] args) {
        //singleDimensionArray();
    }

    static public void singleDimensionArray(){

        /**
         * int[] a = new int[row];
         * int[][] b = new int[row][column];
         * int[][][] c = new int[row][column][];
         */

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
        for(int i=0;i<anArray.length;i++){ // i works as index here
            System.out.println(anArray[i]);
        }

        anArray = new int[]{1, 2, 3, 4, 5};

        System.out.println(anArray[0]+"-"+anArray[anArray.length -1]);

        int[] anArray1={};
        int[] anArray2={1,2,3,4,45};
        System.out.println(anArray1.length+"-"+anArray2.length);

        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };

        for(var i=0;i<names.length;i++){
            for(var j=0;j<names[i].length;j++) {
                System.out.println("names::" + names[i][j]);
            }
        }

        int[][]  arr = {{1,2},{3,4}};
        for(var i=0;i<arr.length;i++){
            for(var j=0;j<arr[i].length;j++) {
                System.out.println("arr::" + arr[i][j]);
            }
        }
    }



}
