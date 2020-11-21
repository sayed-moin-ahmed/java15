package com.java15.example.classesobjects;

import java.util.Currency;

public record CustomRecord() implements SubInterface {
    static {
        System.out.println("CustomRecord static1");
    }

    public CustomRecord{
        System.out.println("CustomRecord");
    }

    static {
        System.out.println("CustomRecord static2");
    }

    @Override
    public void show() {
        System.out.println("Demo");
    }

}
