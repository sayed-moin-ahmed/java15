package com.java15.example.localvariable;

import com.java15.example.collections.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * https://docs.oracle.com/en/java/javase/11/language/local-variable-type-inference.html
 * https://openjdk.java.net/projects/amber/LVTIstyle.html
 */
public class Application {

    public static void main(String[] args){
        // Invalid declaration ->var url = null;
        readURL();
        collectionDemo();
        forLoop();
    }

    private static void forLoop() {
        for(var counter = 0.0; counter<10; counter++){
            System.out.println(counter);
        }
    }

    private static void collectionDemo() {
        var list = new ArrayList<Customer>();
        var customer1=new Customer(1,"World");
        list.add(customer1);
        list.add(new Customer(2,"Sam"));
        var stream = list.stream();
        var element = stream.map(Customer::getName).findFirst();
        element.ifPresent(s -> stringConsumer.accept(s));
        for(var customer : list)
            customerConsumer.accept(customer);
    }

    static Consumer<String> stringConsumer = System.out::println;

    static Consumer<Customer> customerConsumer = System.out::println;

    private static void readURL() {
        try {
            var url= new URL("http://www.oracle.com");
            var conn = url.openConnection();;
            var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Function<String, String> fixedSubStr =  str -> str.substring(0,2);
    BiFunction<String,Integer, String> varSubStr1 = (var str,var val) -> str.substring(0,val);
    BiFunction<String,Integer, String> varSubStr2 = (str,val) -> str.substring(0,val);
    Function<String, String> subStr =  str -> str.substring(0,2);
}
