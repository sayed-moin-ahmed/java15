package com.java15.example.generics;

import java.util.List;

public interface PayloadList<E,P> extends List<E> {
    void setPayload(int index, P val);
}