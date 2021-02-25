package com.java15.example.ic;

public class Main {
    public static void main(String[] args){
        System.out.println(countWays(4));
    }

    public static int countWays(int steps){
        if(steps==1 || steps==0)
            return  1;
        else if(steps==2)
            return  2;
        else
            return countWays(steps-2)+countWays(steps-1);
    }

}

