package com.java15.example.java8inaction;

public class Test {

    public static void main(String[] args){

        int counter = 0;
        int temp;
        //9,3,6,5,7,2
        int[] arr ={10,9,3,6,5,7,2,13};
        for(int i= 0; i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    counter++;
                    if(counter>2) {
                        break;
                    }
                }
            }

        }
        System.out.println(counter);


    }

}
