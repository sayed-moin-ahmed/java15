package com.java15.example.annotations;

import java.lang.annotation.Documented;

@Documented
public @interface Author {
    String name();
    String date();
}
