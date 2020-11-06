package com.java15.example.sealed;

import com.java15.example.record.Rectangle;

/**
 * Permitted in interface,record and class.
 */
public sealed interface SubTopInterface extends TopInterface permits SubSubTopInterface, Rectangle {
    default String show(){
        return "SubTopInterface";
    }
}
