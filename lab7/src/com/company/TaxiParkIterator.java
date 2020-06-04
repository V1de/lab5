package com.company;

import java.util.Iterator;

public class TaxiParkIterator<T> implements Iterator<T> {
    private TaxiParkNode<T> current;
    TaxiParkIterator(TaxiParkNode<T> head) {
        current = head;
    }

    public boolean hasNext() {
        return current!=null;
    }
    public T next(){
        T data = (T) current.value;
        current = current.next;
        return data;
    }
}
