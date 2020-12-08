package com.java15.example.annotations;

import java.lang.annotation.*;

/**
 * https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
    String date();
}
