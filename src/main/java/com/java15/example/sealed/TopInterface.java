package com.java15.example.sealed;

public sealed interface TopInterface permits SubTopInterface {
    String show();
}
