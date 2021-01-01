package com.java15.example.environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws IOException {
        Properties properties =  new Properties();
        FileInputStream in = new FileInputStream("application");
        properties.load(in);
        in.close();
    }
}
