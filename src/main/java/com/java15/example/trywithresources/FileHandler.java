package com.java15.example.trywithresources;


import java.io.*;

public class FileHandler extends BufferedReader implements AutoCloseable{


    public FileHandler(Reader in, int sz) {
        super(in, sz);
    }

    public FileHandler( Reader in) {
        super(in);
    }

    @Override
    public void close() {
        System.out.println("AutoCloseable::Closing the resources...");
    }
}
