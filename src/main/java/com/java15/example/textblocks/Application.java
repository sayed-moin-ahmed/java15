package com.java15.example.textblocks;

/**
 * https://docs.oracle.com/en/java/javase/15/text-blocks/index.html
 */
public class Application {

    /**
     *  Text block : """     """
     * @param args
     */
    public static void main(String[] args){
        demo();


    }

    private static void equals(){
        String str ="Hello World";
        String txt = """
                Hello World""";
        System.out.println("=="+(str==txt));
        System.out.println("equals"+str.equals(txt));
        System.out.println("equals"+(str.length()==txt.length()));
    }

    private static void demo() {
        String textBlocks= """
                Hello world %s""";
        String name = "Demo";
        System.out.println(String.format(textBlocks,name));
    }


}
