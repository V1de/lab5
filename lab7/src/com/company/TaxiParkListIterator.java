package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ListIterator;

public class TaxiParkListIterator<T> implements ListIterator<T> {
    private TaxiParkNode<T> current;
    private TaxiParkNode<T> head;
    TaxiParkListIterator(TaxiParkNode<T> node) {
        current = node;
        head = node;
    }

    public boolean hasPrevious(){
        return current != head;
    }

    public T previous(){
        TaxiParkNode<T> tmpN = head;
        while (tmpN.next != current) tmpN = tmpN.next;
        current = tmpN;
        return tmpN.value;
    }

    public int nextIndex(){
        int i = 0;
        TaxiParkNode<T> tmpN = head;
        while (tmpN.next != current) {
            i++;
            tmpN = tmpN.next;
        }
        return i+1;
    }

    public int previousIndex(){
        int i = 0;
        TaxiParkNode<T> tmpN = head;
        while (tmpN.next != current) {
            i++;
            tmpN = tmpN.next;
        }
        return i-1;
    }


    public void remove(){
        if (head == current) {
            head = head.next;
            current = head;
            return;
        }
        TaxiParkNode<T> tmpN = head;
        while (tmpN.next != current) {
            tmpN = tmpN.next;
        }
        if (current.next == null) {
            tmpN.next = null;
            current = tmpN;
            return;
        }
        tmpN.next = tmpN.next.next;
        current = tmpN.next;
        return;
    }

    public void set(T e){
        current.value = e;
        return;
    }

    public void add(T e){
        if (current == head){
            TaxiParkNode<T> tmpH = head.next;
            head.next = new TaxiParkNode<T>(e);
            head.next.next = tmpH;
            return;
        }
        TaxiParkNode<T> tmpN = current.next;
        current.next = new TaxiParkNode<T>(e);
        current.next.next = tmpN;
        return;
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
