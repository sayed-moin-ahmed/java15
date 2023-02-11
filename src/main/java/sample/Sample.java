package sample;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface CustomConsumer<T> {
    void accept(T t);
}


class Root implements Consumer<String>, CustomConsumer<String>,BiConsumer<String,String> {
    public void accept(){
        System.out.println("Root::test method without arguments");
    }
    public void accept(String var1){
        System.out.println("Root::test method with one arguments "+var1);
    }
    public void accept(String var1,String var2){
        System.out.println("Root::test method with two arguments "+var1+" "+var2);
    }
}

class Extended extends Root{
    public void accept(){
        System.out.println("Extended::test method without arguments");
    }
    public void accept(String var1){
        System.out.println("Extended::test method with one arguments "+var1);
    }
    public void accept(String var1,String var2){
        System.out.println("Extended::test method with two arguments "+var1+" "+var2);
    }
}



public class Sample {
    public static void main(String[] args) {
        Supplier<Extended> supplier = Extended::new;
        Root extended = supplier.get();
        extended.accept();
        extended.accept("Hello");
        extended.accept("Hello","world");
    }
}
