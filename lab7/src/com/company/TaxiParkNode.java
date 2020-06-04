package com.company;

public class TaxiParkNode<T> {
    public T value;
    public TaxiParkNode<T> next;
    TaxiParkNode(T v) {
        value = v;
        next=null;
    }
}
