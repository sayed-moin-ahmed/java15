package com.java15.example.java8inaction.Java8_9_10_11_whatshappening;

import java.io.File;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Apple apple1 = new Apple(10,Colors.GREEN);
        Apple apple2 = new Apple(1,Colors.RED);
        Apple apple3 = new Apple(5,Colors.GREEN);
        Apple apple4 = new Apple(3,Colors.RED);
        Apple apple5 = new Apple(4,Colors.GREEN);
        List<Apple> apples =  List.of(apple1,apple2,apple3,apple4,apple5);


    }

    File[] handlingFiles(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }


}
