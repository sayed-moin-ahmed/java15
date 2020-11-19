package com.java15.example.oopconcept;

/**
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html
 */
public class LoopsAndBranchingStatements {
    public static void main(String[] args){
        forWithSpace();
        forExamples();
    }

    /**
     * Run the program.
     */
    public static void forWithSpace(){
        for(int i=0;i<10;i++)


            System.out.println("Hello");
    }

    public static void forExamples(){
        for(int i=0;i<10;i++){
            System.out.println("Normal Loop::"+i);
        }

        label1:for(int i=0;i<5;i++){
            System.out.println("Block Lable1::"+i);
            lable2:for(int j=0;j<i;j++){
                System.out.println("Block Lable2::"+j);
                if(j==3)
                    break label1;
            }
        }

        String val="Hello World";
        int counter = 0;
        for(int i = 0;i<val.length();i++){
            if(val.charAt(i)!= 'l') {
                continue;
            }
            counter++;
        }
        System.out.println("L COUNT::"+counter);
    }




}
